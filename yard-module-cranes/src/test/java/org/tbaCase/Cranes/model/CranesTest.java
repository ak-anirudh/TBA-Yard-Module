package org.tbaCase.Cranes.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CranesTest {
    @Test
    public void testThePositionOfACrane(){

        Cranes cranes = new Cranes();
        Position position = cranes.getPosition();
        assertEquals(Position.START, position);
    }

}