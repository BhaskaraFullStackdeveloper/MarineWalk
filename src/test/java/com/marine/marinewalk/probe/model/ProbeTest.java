package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbeTest {

    @Test
    public void changePosition_ShouldTakeAnyPositionGiven(){
        Probe probe = new Probe(new GridCell(0,1,true),new GridCell());

        Assertions.assertEquals(0,probe.getPosition().getX());
        Assertions.assertEquals(1,probe.getPosition().getY());
        Assertions.assertNull(probe.getFacingTowards().getHasObstacle());

    }

    @Test
    public void changeDirection_ShouldTakeAnyDirectionGiven(){
        Probe probe = new Probe(new GridCell(0,1,true),new GridCell(1,1,true));

        Assertions.assertEquals(1,probe.getFacingTowards().getX());
        Assertions.assertEquals(1,probe.getFacingTowards().getY());
        Assertions.assertTrue(probe.getFacingTowards().getHasObstacle());

    }

}