package com.marine.marinewalk.probe.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbeControllerModuleTest {

    //place a probe on grid
    @Test
    public void placeProbeOnGrid_ShouldBeSuccessful(){

        Assertions.assertTrue(false);
    }
    //place probe on invalid grid location
    @Test
    public void placeProbeOnGrid_WithInvalidRange_shouldBeInvalid(){

        Assertions.assertFalse(true);
    }
    //check probe facing obstacle?
    @Test
    public void checkProbeDirection_withObstacle_shouldSayHasObstacle(){

        Assertions.assertTrue(false);
    }
    //check probe facing is clear
    @Test
    public void checkProbeDirection_withoutObstacle_shouldSayClear(){

        Assertions.assertFalse(true);
    }
    //move probe forward
    @Test
    public void moveForward_WithValidInput_ShouldMoveOneGridForward(){

        Assertions.assertEquals(0,1);
        Assertions.assertEquals(1,0);
    }
    //move probe forward when there is obstacle
    @Test
    public void moveForward_WithObstacle_ShouldSayHasObstacle(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe forward out of bounds
    @Test
    public void moveForward_WithInValidInput_ShouldSayOutOfBounds(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }

    //move probe backward
    @Test
    public void moveBackward_WithValidInput_ShouldMoveOneGridForward(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe backward when there is obstacle
    @Test
    public void moveBackward_WithObstacle_ShouldSayHasObstacle(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe backward out of bounds
    @Test
    public void moveBackward_WithInValidInput_ShouldSayOutOfBounds(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }

    //move probe left
    @Test
    public void moveLeft_WithValidInput_ShouldMoveOneGridForward(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe left when there is obstacle
    @Test
    public void moveLeft_WithObstacle_ShouldSayHasObstacle(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe left out of bounds
    @Test
    public void moveLeft_WithInValidInput_ShouldSayOutOfBounds(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }

    //move probe right
    @Test
    public void moveRight_WithValidInput_ShouldMoveOneGridForward(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe right when there is obstacle
    @Test
    public void moveRight_WithObstacle_ShouldSayHasObstacle(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }
    //move probe right out of bounds
    @Test
    public void moveRight_WithInValidInput_ShouldSayOutOfBounds(){

        Assertions.assertTrue(false);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1,1);
    }

    //get moving commands
    //collect cells visited


}