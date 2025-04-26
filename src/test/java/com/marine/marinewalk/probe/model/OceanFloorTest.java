package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OceanFloorTest {

    @Test
    public void isValidFloorMap_WithNullData_ShouldReturnInvalid(){
        OceanFloor floorToExplore = new OceanFloor();

        GridMap gridMap=new GridMap();
        gridMap.createMap(new Boolean[2][3]);
        Assertions.assertFalse(floorToExplore.isValidFloorMap(gridMap));
    }

    @Test
    public void isOutOfRange_With1X2Data_ShouldReturnOutOfRange(){
        OceanFloor floorToExplore = new OceanFloor();

        GridMap gridMap=new GridMap();
        Boolean[][] oneDimensionalMap={{false, false}};
        gridMap.createMap(oneDimensionalMap);
        Assertions.assertFalse(floorToExplore.isValidRange(gridMap));
    }

    @Test
    public void createFloorToExplore_shouldReturnTheValidGridMap(){
        OceanFloor floorToExplore = new OceanFloor();

        GridMap gridMap=new GridMap();
        Boolean[][] validMap={{false, false},{true,false}};
        GridCell[][] map = gridMap.createMap(validMap);
        boolean floorToExploreCreated = floorToExplore.createFloorToExplore(new GridMap(map));


        Assertions.assertTrue(floorToExploreCreated);
        Assertions.assertInstanceOf(GridMap.class,floorToExplore.getFloorToExplore());
        Assertions.assertEquals(2,floorToExplore.getFloorToExplore().getGridCells().length);
        Assertions.assertEquals(2,floorToExplore.getFloorToExplore().getGridCells()[0].length);
    }

    @Test
    public void createFloorToExplore_withInvalidMap_ShouldReturnFalse(){
        OceanFloor floorToExplore = new OceanFloor();

        GridMap gridMap=new GridMap();
        Boolean[][] inValidMap={{false},{true},{false}};
        GridCell[][] map = gridMap.createMap(inValidMap);
        boolean floorToExploreCreated = floorToExplore.createFloorToExplore(new GridMap(map));

        Assertions.assertFalse(floorToExploreCreated,"Not a valid range floor!");

    }
}