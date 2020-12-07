package com.demo.rover.remotecontrol.command;

import com.demo.rover.remotecontrol.boundary.Rover;

public class MoveBackwardCommand implements Command {

    private Rover rover;

    public MoveBackwardCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() {
        this.rover.moveBackward();
    }
}
