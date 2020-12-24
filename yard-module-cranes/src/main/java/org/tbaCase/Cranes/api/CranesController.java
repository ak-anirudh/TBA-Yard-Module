package org.tbaCase.Cranes.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tbaCase.Cranes.model.Cranes;
import org.tbaCase.Cranes.service.CranesService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CranesController {

	private final CranesService cranesService;
	
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Set<Cranes> getCranes() {
		return cranesService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Cranes getCranesById(@PathVariable Long id) {
		return cranesService.findById(id);
	}

	@GetMapping(value = "/{id}/reset")
	@ResponseBody
	public Cranes reset(@PathVariable Long id) {
		cranesService.reset(id);
		return getCranesById(id);
	}

	@GetMapping(value = "/{id}/moveLeft")
	public void moveLeft(@PathVariable Long id) {
		cranesService.moveLeft(id);
	}

	@GetMapping("/{id}/moveRight")
	public void moveRight(@PathVariable Long id) {
		cranesService.moveRight(id);
	}
	
	@PostMapping(value = "/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Cranes createNewCrane() {
		return cranesService.createNewVehicle();
	}
}
