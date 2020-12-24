package org.tbaCase.UI.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Position {

	private Long id;
	private int x;

	public Position(Long id, int x) {
		super();
		this.id = id;
		this.x = x;
	}


}
