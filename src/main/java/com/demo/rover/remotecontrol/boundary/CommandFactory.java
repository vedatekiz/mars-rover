package com.demo.rover.remotecontrol.boundary;

import com.demo.rover.remotecontrol.command.Command;
import com.demo.rover.remotecontrol.command.MoveBackwardCommand;
import com.demo.rover.remotecontrol.command.MoveForwardCommand;

public class CommandFactory {

    public static Command getCommand(String commandString, Rover rover) {
        if (commandString == null) {
            return null;
        } else if ("F".equals(commandString)) {
            return new MoveForwardCommand(rover);
        } else if ("B".equals(commandString)) {
            return new MoveBackwardCommand(rover);
        }
        return null;
    }
}
