package com.marine.marinewalk.probe.utils;

import com.marine.marinewalk.probe.model.GridCell;
import com.marine.marinewalk.probe.model.OceanFloor;
import com.marine.marinewalk.probe.model.Probe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProbeControllerModule {

	private OceanFloor oceanFloor;
	private Probe probe;
	private List<GridCell> visitedCoordinates = new ArrayList<>();

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

	public boolean placeProbeOnGrid(Probe probe) {
		GridCell startingPosition = probe.getPosition();
		GridCell faceDirection = probe.getFacingTowards();
		if (!isGridCellInValidRange(startingPosition) || !isGridCellInValidRange(faceDirection)) {
			return false;
		}

		if (this.oceanFloor.getFloorToExplore().getGridCells()[startingPosition.getX()][startingPosition.getY()]
				.getHasObstacle()) {
			return false;
		}

		this.probe = probe;
		return true;
	}

	private boolean isGridCellInValidRange(GridCell startingPosition) {
		int rows = this.oceanFloor.getFloorToExplore().getGridCells().length;
		int cols = this.oceanFloor.getFloorToExplore().getGridCells()[0].length;

		return startingPosition.getX() >= 0 && startingPosition.getX() < rows && startingPosition.getY() >= 0
				&& startingPosition.getY() < cols;
	}

	public boolean moveForward() {
	    GridCell currentPosition = probe.getPosition();
	    GridCell facing = probe.getFacingTowards();

	    // Compute new position
	    int newX = facing.getX();
	    int newY = facing.getY();

	    // Compute new facing direction (it shifts forward)
	    int newFacingX = newX + (facing.getX() - currentPosition.getX());
	    int newFacingY = newY + (facing.getY() - currentPosition.getY());

	    if (isValidMove(newX, newY)) {
	        probe.move(new GridCell(newX, newY, false));
	        probe.ChangeDirection(new GridCell(newFacingX, newFacingY, false)); // Update facing
	        return true;
	    }
	    return false;
	}


	public boolean moveBackward() {
	    GridCell currentPosition = probe.getPosition();
	    GridCell facingDirection = probe.getFacingTowards();

	    // Compute new position (opposite to the facing direction)
	    int newX = currentPosition.getX() - (facingDirection.getX() - currentPosition.getX());
	    int newY = currentPosition.getY() - (facingDirection.getY() - currentPosition.getY());

	    // Compute new facing direction (it shifts backward)
	    int newFacingX = newX - (facingDirection.getX() - currentPosition.getX());
	    int newFacingY = newY - (facingDirection.getY() - currentPosition.getY());

	    if (isValidMove(newX, newY)) {
	        probe.move(new GridCell(newX, newY, false));
	        probe.ChangeDirection(new GridCell(newFacingX, newFacingY, false)); // Update facing
	        return true;
	    }
	    return false;
	}


	public boolean moveLeft() {
	    GridCell currentPosition = probe.getPosition();
	    GridCell currentFacing = probe.getFacingTowards();

	    int newX = currentPosition.getX() - 1;
	    int newY = currentPosition.getY();

	    int newFacingX = currentFacing.getX() - 1;
	    int newFacingY = currentFacing.getY();

	    if (isValidMove(newX, newY)) {
	        probe.move(new GridCell(newX, newY, false));
	        probe.ChangeDirection(new GridCell(newFacingX, newFacingY, false));
	        return true;
	    }
	    return false;
	}


	public boolean moveRight() {
	    GridCell currentPosition = probe.getPosition();
	    GridCell currentFacing = probe.getFacingTowards();

	    int newX = currentPosition.getX() + 1;
	    int newY = currentPosition.getY();

	    int newFacingX = currentFacing.getX() + 1;
	    int newFacingY = currentFacing.getY();

	    if (isValidMove(newX, newY)) {
	        probe.move(new GridCell(newX, newY, false));
	        probe.ChangeDirection(new GridCell(newFacingX, newFacingY, false));
	        return true;
	    }
	    return false;
	}


	public boolean executeCommands(List<Character> commands) {
		for (char command : commands) {
			boolean moved = false;
			switch (command) {
			case 'F':
				moved = moveForward();
				break;
			case 'B':
				moved = moveBackward();
				break;
			case 'L':
				moved = moveLeft();
				break;
			case 'R':
				moved = moveRight();
				break;
			default:
				System.out.println("Invalid command: " + command);
			}

			if (moved) {
				visitedCoordinates.add(new GridCell(probe.getPosition().getX(), probe.getPosition().getY(), false));
			}
		}
		return true;
	}

	public void printVisitedCoordinates() {
		System.out.println("Visited Coordinates:");
		for (GridCell cell : visitedCoordinates) {
			System.out.println("(" + cell.getX() + ", " + cell.getY() + ")");
		}
	}

	private boolean isValidMove(int x, int y) {
		return x >= 0 && x < oceanFloor.getFloorToExplore().getGridCells().length && y >= 0
				&& y < oceanFloor.getFloorToExplore().getGridCells()[0].length
				&& !oceanFloor.getFloorToExplore().getGridCells()[x][y].getHasObstacle();
	}

}
