package org.tbaCase.Cranes.model;

import javax.persistence.*;

/**
 * Represents a position on a discrete two-dimensional net. The directions are
 * negative x(left), positive x(right)
 */
@Entity
@Table(name = "position")
public class Position {

	public enum Direction {
		LEFT, RIGHT
	}

	public Position() {
		x = 0;
	}

	public static Position START = Position.of(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "x")
	private final int x;

	private Position(int x) {
		this.x = x;
	}

	public static Position of(int x) {
		return new Position(x);
	}

	public int getX() {
		return x;
	}

	public Position transform(Direction direction) {
		if (direction == null) {
			return null;
		}
		switch (direction) {
		case LEFT:
			return Position.of(x - 1);
		case RIGHT:
			return Position.of(x + 1);
		default:
			throw new UnsupportedOperationException("Can't move in direction " + direction);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		return true;
	}

}
