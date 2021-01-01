package org.tbaCase.Cranes.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.tbaCase.Cranes.model.Cranes;
import org.tbaCase.Cranes.model.Position;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CranesRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CranesRepository cranesRepository;

    @Test
    public void testFindByIdWithCrane(){
        Cranes cranes = new Cranes();
        cranes.setPosition(Position.of(1));

        testEntityManager.persist(cranes);
        testEntityManager.flush();

        Cranes inYard = cranesRepository.findById(cranes.getId()).get();

        assertEquals(Position.of(1), inYard.getPosition());
    }
}