package org.tbaCase.UI.client;

public class Cranes implements Comparable<Cranes> {

	private Long id;
	private Position position;

	public Cranes() {
	}

	public Cranes(Long id, Position position) {
		super();
		this.id = id;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "VehicleBean [id=" + id + ", position=" + position + "]";
	}

	@Override
	public int compareTo(Cranes o) {
		return id.compareTo(o.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cranes other = (Cranes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
