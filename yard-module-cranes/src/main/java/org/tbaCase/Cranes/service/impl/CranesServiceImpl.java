package org.tbaCase.Cranes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tbaCase.Cranes.model.Position;
import org.tbaCase.Cranes.model.Position.Direction;
import org.tbaCase.Cranes.model.Cranes;
import org.tbaCase.Cranes.repository.CranesRepository;
import org.tbaCase.Cranes.service.CranesService;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CranesServiceImpl implements CranesService {

	private final CranesRepository repository;

	@Override
	public void reset(Long id) {
		Cranes cranes = findById(id);
		cranes.setPosition(Position.START);
		save(cranes);
	}

	private void move(Long id, Direction direction) {
		Cranes cranes = findById(id);
		cranes.setPosition(cranes.getPosition().transform(direction));
		save(cranes);
	}

	private Cranes save(Cranes cranes) {
		return repository.save(cranes);
	}

	@Override
	public void moveLeft(Long id) {
		move(id, Direction.LEFT);
	}

	@Override
	public void moveRight(Long id) {
		move(id, Direction.RIGHT);
	}

	@Override
	public Cranes findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Set<Cranes> findAll() {
		return new HashSet<>(repository.findAll());
	}

	@Override
	public Cranes createNewVehicle() {
		return save(new Cranes());
	}

}
