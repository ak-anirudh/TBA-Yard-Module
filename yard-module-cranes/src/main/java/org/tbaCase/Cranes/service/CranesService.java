package org.tbaCase.Cranes.service;

import org.tbaCase.Cranes.model.Cranes;

import java.util.Set;

public interface CranesService {

	void reset(Long id);
	void moveLeft(Long id);
	void moveRight(Long id);
	Cranes findById(Long id);
	Set<Cranes> findAll();
	Cranes createNewVehicle();

}
