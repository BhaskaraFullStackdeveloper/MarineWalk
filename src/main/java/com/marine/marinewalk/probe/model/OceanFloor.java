package com.marine.marinewalk.probe.model;

import java.util.Objects;

public class OceanFloor {
    private GridMap floorToExplore;

    public OceanFloor() {
    }

    public OceanFloor(GridMap floorToExplore) {
        this.floorToExplore = floorToExplore;
    }

    public GridMap getFloorToExplore() {
        return floorToExplore;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OceanFloor that = (OceanFloor) o;
        return Objects.equals(floorToExplore, that.floorToExplore);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(floorToExplore);
    }

    public void setFloorToExplore(GridMap floorToExplore) {
        this.floorToExplore = floorToExplore;
    }

    @Override
    public String toString() {
        return "OceanFloor{" +
                "floorToExplore=" + floorToExplore +
                '}';
    }

    //TODO:throw new InvalidGridMapDataException("Obstacles can be set with true or false, invalid data type exception!");
    public boolean isValidFloorMap(GridMap map){
        for (int i = 0; i < map.getGridCells().length; i++) {
            for (int j = 0; j < map.getGridCells()[i].length; j++) {
                if (map.getGridCells()[i][j].getHasObstacle() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        Defaulting to 2 X 2 matrics as 1 cell cannot be considered as a map
    */
    public boolean isOutOfRange(GridMap map){
        if (map.getGridCells().length == 0) {
            return true;
        }
        int rows = map.getGridCells().length;
        int cols = map.getGridCells()[0].length;
        if(rows<2 && cols <2){
            return true;
        }

        return false;
    }
}
