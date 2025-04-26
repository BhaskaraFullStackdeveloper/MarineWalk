package com.marine.marinewalk.probe.utils;

import com.marine.marinewalk.probe.model.GridCell;
import com.marine.marinewalk.probe.model.OceanFloor;
import com.marine.marinewalk.probe.model.Probe;
import org.springframework.stereotype.Component;

@Component
public class ProbeControllerModule {

	private OceanFloor oceanFloor;
	private Probe probe;

	public ProbeControllerModule(OceanFloor floorMap) {
		this.oceanFloor = floorMap;
	}

	public OceanFloor getOceanFloor() {
		return oceanFloor;
	}

	public void setOceanFloor(OceanFloor oceanFloor) {
		this.oceanFloor = oceanFloor;
	}

	public Probe getProbe() {
		return probe;
	}

	public void setProbe(Probe probe) {
		this.probe = probe;
	}

	// should be able to control the probe
	// change position of the probe - with area boundaries validation
	// change direction of the probe - with validation and tell if out of range
	// direction or in range
	// starting position
	public boolean placeProbeOnGrid(Probe probe) {
		GridCell startingPosition = probe.getPosition();
		GridCell faceDirection = probe.getFacingTowards();
	    if (!isGridCellInValidRange(startingPosition) || !isGridCellInValidRange(faceDirection)) {
	        return false;
	    }

	    if (this.oceanFloor.getFloorToExplore().getGridCells()[startingPosition.getX()][startingPosition.getY()].getHasObstacle()) {
	        return false;
	    }

	    this.probe = probe;
	    return true;
	}

	private boolean isGridCellInValidRange(GridCell startingPosition) {
	    int rows = this.oceanFloor.getFloorToExplore().getGridCells().length;
	    int cols = this.oceanFloor.getFloorToExplore().getGridCells()[0].length;

	    return startingPosition.getX() >= 0 && startingPosition.getX() < rows &&
	    		startingPosition.getY() >= 0 && startingPosition.getY() < cols;
	}

	// move forward
	public boolean moveForward() {

		GridCell currentPosition = probe.getPosition();
		GridCell facing = probe.getFacingTowards();
	    int newX = currentPosition.getX() + (facing.getX() - currentPosition.getX());
	    int newY = currentPosition.getY() + (facing.getY() - currentPosition.getY());

	    if (isValidMove(newX, newY)) {
	        probe.move(new GridCell(newX, newY, false));
	        return true;
	    }
	    return false;
	}
	// move backword
	// move left
	// move right
	// check hasObstacle
	// get collection of commands -read - move the probe accordingly
	// printSummary

	private boolean isValidMove(int x, int y) {
		return x >= 0 && x < oceanFloor.getFloorToExplore().getGridCells().length && y >= 0
				&& y < oceanFloor.getFloorToExplore().getGridCells()[0].length
				&& !oceanFloor.getFloorToExplore().getGridCells()[x][y].getHasObstacle();
	}

}
