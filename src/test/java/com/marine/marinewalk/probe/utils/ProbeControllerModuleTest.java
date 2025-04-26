package com.marine.marinewalk.probe.utils;

import com.marine.marinewalk.probe.model.GridCell;
import com.marine.marinewalk.probe.model.GridMap;
import com.marine.marinewalk.probe.model.OceanFloor;
import com.marine.marinewalk.probe.model.Probe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbeControllerModuleTest {

    //place a probe on grid
    @Test
	public void placeProbeOnGrid_ShouldBeSuccessful(){
        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false},{false,false},{false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);


        Assertions.assertTrue(placedProbeOnGrid);
    }
    //place probe on invalid grid location
    @Test
    public void placeProbeOnGrid_WithInvalidRange_shouldBeInvalid(){

        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(2,1,false),new GridCell(1,3,false));

        Boolean[][] map={{false,false},{false,false},{false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);

        Assertions.assertFalse(placedProbeOnGrid);
    }
    //check probe facing obstacle?
    @Test
    public void checkProbeDirection_withObstacle_shouldSayHasObstacle(){

        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,true,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedForward = controllerModule.moveForward();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedForward);
    }
    //check probe facing is clear
    @Test
    public void checkProbeDirection_withoutObstacle_shouldSayClear(){

        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(2,1,false),new GridCell(1,3,false));

        Boolean[][] map={{false,false},{false,false},{false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        
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