package com.marine.marinewalk.probe.model;

import java.io.Serializable;
import java.util.Objects;

public class Probe implements Serializable {

    private GridCell position;
    private GridCell facingTowards;

    public Probe() {
    }

    public Probe(GridCell position, GridCell facingTowards) {
        this.position = position;
        this.facingTowards = facingTowards;
    }

    public GridCell getPosition() {
        return position;
    }

    public void setPosition(GridCell position) {
        this.position = position;
    }

    public GridCell getFacingTowards() {
        return facingTowards;
    }

    public void setFacingTowards(GridCell facingTowards) {
        this.facingTowards = facingTowards;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Probe probe = (Probe) o;
        return Objects.equals(position, probe.position) && Objects.equals(facingTowards, probe.facingTowards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, facingTowards);
    }

    @Override
    public String toString() {
        return "Probe{" +
                "position=" + position +
                ", facingTowards=" + facingTowards +
                '}';
    }

    public void move(GridCell newPosition){
        this.position = newPosition;
    }

    public void ChangeDirection(GridCell newDirection){
        this.facingTowards = newDirection;
    }
}
