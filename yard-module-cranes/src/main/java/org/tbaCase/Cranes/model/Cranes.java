package org.tbaCase.Cranes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Data
public class Cranes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "position_id")
	private Position position;

	public Cranes() {
		position = Position.of(0);
	}

}
