package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertFalse(floorToExplore.isOutOfRange(gridMap));
    }

    @Test
    public void createFloorToExplore_shouldReturnTheValidGridMap(){
        Assertions.assertInstanceOf(GridMap.class,null);
        Assertions.assertEquals(2,0);
        Assertions.assertEquals(2,0);
    }

    @Test
    public void createFloorToExplore_withInvalidMap_ShouldReturnFalse(){

        Assertions.assertTrue(null);

    }
}