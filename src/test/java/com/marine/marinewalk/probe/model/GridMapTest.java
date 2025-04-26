package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridMapTest {

    @Test
    public void createMap_ShouldReturn2DMatrixOfBoolValues() {
        GridMap map = new GridMap();
        Boolean[][] coordinates = new Boolean[3][3];
        GridCell[][] defaultMap = map.createMap(coordinates);
        Assertions.assertEquals(3,defaultMap.length,"Should have same number of rows");
        Assertions.assertEquals(3,defaultMap[0].length,"Should have same number of columns");
    }

    @Test
    public void createMap_WithGivenInput_ShouldReturnSameCoordintesWithValues() {
        GridMap map = new GridMap();
        Boolean[][] coordinates = new Boolean[3][3];

        //Set 3 X 3 matrix with center (1,1) has obstacle
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                coordinates[i][j] = i == 1 && j == 1;
            }
        }
        //Create Map
        GridCell[][] defaultMap = map.createMap(coordinates);

        //test if we are getting same map that we have created from create map output
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if(i == 1 && j == 1){
                    Assertions.assertTrue(defaultMap[i][j].getHasObstacle());
                }else
                    Assertions.assertFalse(defaultMap[i][j].getHasObstacle());
            }
        }

    }

    @Test
    public void createMap_shouldReturnGridForGivenCoordinates(){
        GridMap map=new GridMap();
        GridCell[][] coordinates = map.createMap(new Boolean[3][3]);
        Assertions.assertInstanceOf(GridCell.class,coordinates[0][0]);
    }

    @Test
    public void createMap_ForGiven4X5_ShouldCreate4X5matrixOfGridCells(){
        GridMap map = new GridMap();
        //Create 4 X 5 matrix
        Boolean[][] coordinates = new Boolean[4][5];

        //Instantiate 4 X 5 matrix with last 2 rows all obstacles
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                coordinates[i][j] = i > 1;
            }
        }
        //Create Map
        GridCell[][] defaultMap = map.createMap(coordinates);

        //test if rows greater than 1 are having obstacles
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if(i > 1){
                    Assertions.assertTrue(defaultMap[i][j].getHasObstacle());
                }else
                    Assertions.assertFalse(defaultMap[i][j].getHasObstacle());
            }
        }

    }
}