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
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,true,false}};
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
        Assertions.assertFalse(movedForward);
    }
    //check probe facing is clear
    @Test
    public void checkProbeDirection_withoutObstacle_shouldSayClear(){

        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedForward = controllerModule.moveForward();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedForward);
        
    }
    //move probe forward
    @Test
    public void moveForward_WithValidInput_ShouldMoveOneGridForward(){
    	
        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedForward = controllerModule.moveForward();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedForward);

        Assertions.assertEquals(0,controllerModule.getProbe().getPosition().getX(),"Moved to x position");
        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"Moved to y position");
    }
    //move probe forward when there is obstacle
    @Test
    public void moveForward_WithObstacle_ShouldSayHasObstacle(){

        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,true,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedForward = controllerModule.moveForward();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertFalse(movedForward);

        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"stay in same position");
        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"stay in same position");
    }
    //move probe forward out of bounds
    @Test
    public void moveForward_WithInValidInput_ShouldSayOutOfBounds(){
    	
        GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(2,2,false),new GridCell(-1,-1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        Assertions.assertThrows(NullPointerException.class, ()->controllerModule.moveForward());
        
        Assertions.assertFalse(placedProbeOnGrid);

    }

    //move probe backward
    @Test
    public void moveBackward_WithValidInput_ShouldMoveOneGridBackward(){
    	GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedBackward = controllerModule.moveBackward();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedBackward);

        Assertions.assertEquals(2,controllerModule.getProbe().getPosition().getX(),"Moved back to x position");
        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"Moved back to y position");
    }
    //move probe backward when there is obstacle
    @Test
    public void moveBackward_WithObstacle_ShouldSayHasObstacle(){

    	 GridMap gridMap=new GridMap();
         Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

         Boolean[][] map={{false,false,false},{false,false,false},{false,true,false}};
         GridCell[][] floorToExplore = gridMap.createMap(map);
         OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
         ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
         boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
         boolean movedBackward = controllerModule.moveBackward();
         
         Assertions.assertTrue(placedProbeOnGrid);
         Assertions.assertFalse(movedBackward);

         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"stay in same position");
         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"stay in same position");
    }
    //move probe backward out of bounds
    @Test
    public void moveBackward_WithInValidInput_ShouldSayOutOfBounds(){

    	GridMap gridMap=new GridMap();
    	
    	Boolean[][] map = {{false, false, false}, {false, false, false}, {false, false, false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        Probe probe = new Probe(new GridCell(2, 2, false), new GridCell(3, 2, false));

        assertFalse(controllerModule.placeProbeOnGrid(probe), "Probe should not be placed.");
        assertThrows(NullPointerException.class, ()->controllerModule.moveBackward(), "Probe should not move backward beyond grid boundaries.");
    }

    //move probe left
    @Test
    public void moveLeft_WithValidInput_ShouldMoveOneGridLeft(){

    	GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedLeft = controllerModule.moveLeft();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedLeft);
        
        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"Moved left to x position");
        Assertions.assertEquals(0,controllerModule.getProbe().getPosition().getY(),"Moved left to y position");

    }
    //move probe left when there is obstacle
    @Test
    public void moveLeft_WithObstacle_ShouldSayHasObstacle(){
    	 GridMap gridMap=new GridMap();
         Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

         Boolean[][] map={{false,false,false},{true,false,false},{false,true,false}};
         GridCell[][] floorToExplore = gridMap.createMap(map);
         OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
         ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
         boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
         boolean movedLeft = controllerModule.moveLeft();
         
         Assertions.assertTrue(placedProbeOnGrid);
         Assertions.assertFalse(movedLeft);

         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"stay in same position");
         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"stay in same position");
    }
    //move probe left out of bounds
    @Test
    public void moveLeft_WithInValidInput_ShouldSayOutOfBounds(){
    	GridMap gridMap=new GridMap();
    	
    	Boolean[][] map = {{false, false, false}, {false, false, false}, {false, false, false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        Probe probe = new Probe(new GridCell(1, 0, false), new GridCell(3, 2, false));

        assertFalse(controllerModule.placeProbeOnGrid(probe), "Probe should not be placed.");
        assertThrows(NullPointerException.class, ()->controllerModule.moveBackward(), "Probe should not move backward beyond grid boundaries.");
    }

    //move probe right
    @Test
    public void moveRight_WithValidInput_ShouldMoveOneGridRight(){
    	GridMap gridMap=new GridMap();
        Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

        Boolean[][] map={{false,false,false},{false,false,false},{false,false,false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
        boolean movedRight = controllerModule.moveRight();
        
        Assertions.assertTrue(placedProbeOnGrid);
        Assertions.assertTrue(movedRight);
        
        Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"Moved right to x position");
        Assertions.assertEquals(2,controllerModule.getProbe().getPosition().getY(),"Moved right to y position");
    }
    
    //move probe right when there is obstacle
    @Test
    public void moveRight_WithObstacle_ShouldSayHasObstacle(){
    	 GridMap gridMap=new GridMap();
         Probe probe=new Probe(new GridCell(1,1,false),new GridCell(0,1,false));

         Boolean[][] map={{false,false,false},{false,false,true},{false,true,false}};
         GridCell[][] floorToExplore = gridMap.createMap(map);
         OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
         ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
         boolean placedProbeOnGrid = controllerModule.placeProbeOnGrid(probe);
         boolean movedRight = controllerModule.moveRight();
         
         Assertions.assertTrue(placedProbeOnGrid);
         Assertions.assertFalse(movedRight);

         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getX(),"stay in same position");
         Assertions.assertEquals(1,controllerModule.getProbe().getPosition().getY(),"stay in same position");
    }
    //move probe right out of bounds
    @Test
    public void moveRight_WithInValidInput_ShouldSayOutOfBounds(){
    	GridMap gridMap=new GridMap();
    	
    	Boolean[][] map = {{false, false, false}, {false, false, false}, {false, false, false}};
        GridCell[][] floorToExplore = gridMap.createMap(map);
        OceanFloor oceanFloor=new OceanFloor(new GridMap(floorToExplore));
        ProbeControllerModule controllerModule=new ProbeControllerModule(oceanFloor);
        Probe probe = new Probe(new GridCell(2, 2, false), new GridCell(3, 2, false));

        assertFalse(controllerModule.placeProbeOnGrid(probe), "Probe should not be placed.");
        assertThrows(NullPointerException.class, ()->controllerModule.moveBackward(), "Probe should not move backward beyond grid boundaries.");
    }

    //get moving commands
    //collect cells visited


}