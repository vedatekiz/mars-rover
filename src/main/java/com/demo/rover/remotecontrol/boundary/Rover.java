package com.demo.rover.remotecontrol.boundary;

public class Rover {

    private Status status;

    public Rover(int x, int y, Direction direction) {
        this.status = new Status();
        this.land(x, y, direction);
    }

    private void land(int x, int y, Direction direction) {
        this.status.setX(x);
        this.status.setY(y);
        this.status.setDirection(direction);
    }

    public void moveForward() {
        switch (this.status.getDirection()) {
            case NORTH:
                this.status.incrementY();
                break;
            case SOUTH:
                this.status.decrementY();
                break;
            case EAST:
                this.status.incrementX();
                break;
            case WEST:
                this.status.decrementX();
                break;
        }
    }

    public void moveBackward() {
        switch (this.status.getDirection()) {
            case NORTH:
                this.status.decrementY();
                break;
            case SOUTH:
                this.status.incrementY();
                break;
            case EAST:
                this.status.decrementX();
                break;
            case WEST:
                this.status.incrementX();
                break;
        }
    }

    public String printStatus() {
        return this.status.printStatus();
    }

//    public void turnRight() {
//        //TODO will be implemented in need
//    }
//
//    public void turnLeft() {
//        //TODO will be implemented in need
//    }

}
