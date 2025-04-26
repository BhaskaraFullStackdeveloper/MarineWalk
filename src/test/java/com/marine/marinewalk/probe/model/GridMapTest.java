package com.marine.marinewalk.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridMapTest {

    @Test
    public void createMap_ShouldReturn2DMatrixOfBoolValues(){
        GridMap map = new GridMap();
        Boolean[][] coordinates =new Boolean[3][3];
        Boolean[][] defaultMap = map.createMap(coordinates);
        for(int i=0;i<coordinates.length;i++){
            for (int j=0;j<coordinates[0].length;j++){
                Assertions.assertFalse(defaultMap[i][j]);
            }
        }
    }
}