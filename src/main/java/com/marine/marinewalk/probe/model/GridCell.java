package com.marine.marinewalk.probe.model;

import java.util.Objects;

/*single unit of a grid*/
public class GridCell {
    private int x;
    private int y;
    private Boolean hasObstacle;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean getHasObstacle() {
        return hasObstacle;
    }

    public void setHasObstacle(Boolean hasObstacle) {
        this.hasObstacle = hasObstacle;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return x == gridCell.x && y == gridCell.y && Objects.equals(hasObstacle, gridCell.hasObstacle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, hasObstacle);
    }
}
