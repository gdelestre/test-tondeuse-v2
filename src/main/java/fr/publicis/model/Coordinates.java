package fr.publicis.model;

import java.util.Objects;

public class Coordinates {
    private int coordinateX;
    private int coordinateY;

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Coordinates(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int moveTowardsNorth(){
        return this.coordinateY++;
    }

    public int moveTowardsSouth(){
        return this.coordinateY--;
    }

    public int moveTowardsEast(){
        return this.coordinateX++;
    }

    public int moveTowardsWest(){
        return this.coordinateX--;
    }

    @Override
    public String toString(){
        return this.coordinateX+" "+this.coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return coordinateX == that.coordinateX &&
                coordinateY == that.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
}
