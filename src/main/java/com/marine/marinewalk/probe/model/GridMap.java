package com.marine.marinewalk.probe.model;

import java.io.Serializable;
import java.util.List;

/*
Grid represents ocean floor in 2 X 2 matrics
*/
public class GridMap implements Serializable {
    private GridCell[][] gridMap;

    public Boolean[][] createMap(Boolean[][] map){

        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                System.out.println(map[i][j]);
            }
        }
        return map;
    }
}
