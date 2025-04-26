package com.marine.marinewalk.probe.model;

import java.io.Serializable;
import java.util.Arrays;

/*
Grid represents ocean floor in 2 X 2 matrics
*/
public class GridMap implements Serializable {
    private GridCell[][] gridCells;

    public GridMap() {
    }

    public GridMap(GridCell[][] gridCells) {
        this.gridCells = gridCells;
    }

    public GridCell[][] getGridCells() {
        return gridCells;
    }

    public void setGridCells(GridCell[][] gridCells) {
        this.gridCells = gridCells;
    }

    @Override
    public String toString() {
        return "GridMap{" +
                "gridCells=" + Arrays.toString(gridCells) +
                '}';
    }

    public GridCell[][] createMap(Boolean[][] map){
        gridCells = new GridCell[map.length][map[0].length];
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                gridCells[i][j] = new GridCell(i,j,map[i][j]);
            }
        }
        return gridCells;
    }
}
