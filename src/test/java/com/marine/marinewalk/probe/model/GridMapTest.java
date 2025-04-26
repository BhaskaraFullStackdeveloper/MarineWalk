package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridMapTest {

    @Test
    public void createMap_ShouldReturn2DMatrixOfBoolValues() {
        GridMap map = new GridMap();
        Boolean[][] coordinates = new Boolean[3][3];
        Boolean[][] defaultMap = map.createMap(coordinates);
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                Assertions.assertFalse(defaultMap[i][j]);
            }
        }
    }

    @Test
    public void createMap_WithGivenInput_ShouldReturnSameCoordintesWithValues() {
        GridMap map = new GridMap();
        Boolean[][] coordinates = new Boolean[3][3];

        //Set 3 X 3 matrix with center (1,1) has obstacle
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if (i == 1 && j == 1) {
                    coordinates[i][j] = true;
                }
                coordinates[i][j] = false;
            }
        }
        //Create Map
        Boolean[][] defaultMap = map.createMap(coordinates);
        for (int i = 0; i < defaultMap.length; i++) {
            for (int j = 0; j < defaultMap[0].length; j++) {
                System.out.println("i: "+i+" j: "+j+" = "+defaultMap[i][j]);
            }
        }
        //test if we are getting same map that we have created from create map output
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if (i == 1 && j == 1) {
                    Assertions.assertTrue(defaultMap[i][j]);
                }
                Assertions.assertFalse(defaultMap[i][j]);
            }
        }

    }
}