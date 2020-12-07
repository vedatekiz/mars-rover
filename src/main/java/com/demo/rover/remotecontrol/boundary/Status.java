package com.demo.rover.remotecontrol.boundary;

public class Status {

    private int x;
    private int y;
    private Direction direction;

    public void incrementX() {
        this.setX(this.getX() + 1);
    }

    public void incrementY() {
        this.setY(this.getY() + 1);
    }

    public void decrementX() {
        this.setX(this.getX() - 1);
    }

    public void decrementY() {
        this.setY(this.getY() - 1);
    }

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String printStatus(){
        return "(" + this.x + ", " + this.y + ") " + this.direction.name();
    }
}
