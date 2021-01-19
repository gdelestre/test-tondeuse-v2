package fr.publicis.model;


public class Lawnmower {

    private Coordinates coordinates;

    private Orientation orientation;

    public Lawnmower(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void changeDirection(char direction) {
        switch (orientation) {
            case N:
                this.orientation = (direction == 'D') ? Orientation.E : Orientation.W;
                break;

            case E:
                this.orientation = (direction == 'D') ? Orientation.S : Orientation.N;
                break;

            case S:
                this.orientation = (direction == 'D') ? Orientation.W : Orientation.E;
                break;

            case W:
                this.orientation = (direction == 'D') ? Orientation.N : Orientation.S;
                break;
        }
    }

    public void move() {
        switch (orientation) {
            case N:
                this.coordinates.moveTowardsNorth();
                break;

            case E:
                this.coordinates.moveTowardsEast();
                break;

            case S:
                this.coordinates.moveTowardsSouth();
                break;

            case W:
                this.coordinates.moveTowardsWest();
                break;
        }
    }

    public String sayInformations() {
        String coordinates = this.coordinates.toString();
        String info = coordinates + " " + this.orientation.toString();
        System.out.println(info);
        return info;
    }

    @Override
    public String toString() {
        return "Lawnmower{" +
                "coordinates=" + coordinates +
                ", orientation=" + orientation +
                '}';
    }
}
