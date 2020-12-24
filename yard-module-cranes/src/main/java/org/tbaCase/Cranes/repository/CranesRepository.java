package org.tbaCase.Cranes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tbaCase.Cranes.model.Cranes;

@Repository
public interface CranesRepository extends JpaRepository<Cranes, Long> {
}
