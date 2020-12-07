package com.demo.rover.remotecontrol.command;

import com.demo.rover.remotecontrol.boundary.Rover;

public class MoveForwardCommand implements Command {

    private Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() {
        this.rover.moveForward();
    }
}
