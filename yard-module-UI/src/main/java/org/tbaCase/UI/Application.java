package org.tbaCase.UI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.tbaCase.UI.client.Cranes;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class Application {

	@PostConstruct
	public void init(){
		System.out.println("Start Moving the Cranes");
	}

	private static Map<Long, ScheduledExecutorService> moveCranes = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		String nextMove = null;
		try (Scanner scanner = new Scanner(System.in)) {
			while (!"exit".equals(nextMove)) {
				printAllCranesInTheModule();
				System.out.println("Select a move ('help' for list of moves):");
				nextMove = scanner.nextLine();
				if ("help".equals(nextMove)) {
					System.out.println("Available moves: help, exit, create, refresh, moveLeft {id], moveRight {id}");
				} else if ("create".equals(nextMove)) {
					createNew();
				} else if (nextMove.trim().startsWith("move")) {
					try {
						int indexOfSpace = nextMove.indexOf(' ');
						String direction = nextMove.substring(4, indexOfSpace);
						long id = Long.parseLong(nextMove.substring(indexOfSpace + 1));
						String capitalizedDirection = direction.substring(0, 1).toUpperCase() + direction.substring(1);
						move(id, capitalizedDirection);
						moveForever(id, capitalizedDirection);
					} catch (NumberFormatException e) {
						System.err.println("Error: '" + nextMove + "' couldn't be interpreted.");
					}
				}
			}
			System.exit(0);
		}
	}

	private static void moveForever(long id, String capitalizedDirection) {
		ScheduledExecutorService executor = moveCranes.get(id);
		if (executor != null) {
			executor.shutdownNow();
		}
		createNewCrane(id, capitalizedDirection);
	}

	private static void createNewCrane(long id, String capitalizedDirection) {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(() -> move(id, capitalizedDirection), 1, 1, TimeUnit.SECONDS);
		moveCranes.put(id, executor);
	}

	private static void move(long id, String direction) {
		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		new RestTemplate()
				.getForEntity("http://localhost:8080/cranes/api/v1/{id}/move" + direction, String.class, uriVariables)
				.getBody();
	}

	private static void createNew() {
		ResponseEntity<Cranes> responseEntity = new RestTemplate().postForEntity("http://localhost:8080/cranes/api/v1/",
				new HashMap<>(), Cranes.class);
		System.out.println("Created " + responseEntity.getBody());
	}

	private static void printAllCranesInTheModule() {
		System.out.println("Here's all Cranes:");
		ResponseEntity<List<Cranes>> responseEntity = new RestTemplate().exchange("http://localhost:8080/cranes/api/v1/",
				HttpMethod.GET, null, new ParameterizedTypeReference<>() {
				});
		responseEntity.getBody()
				.stream()
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

}
