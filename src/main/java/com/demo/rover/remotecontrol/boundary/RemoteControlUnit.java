package com.demo.rover.remotecontrol.boundary;

import com.demo.rover.remotecontrol.command.Command;
import com.demo.rover.remotecontrol.exception.CommandNotFoundException;
import com.demo.rover.remotecontrol.exception.InvalidArgumentException;

public class RemoteControlUnit {

    private Command command;
    private Rover rover;

    public RemoteControlUnit(int x, int y, Direction direction) {
        this.rover = new Rover(x, y, direction);
    }

    public RemoteControlUnit(String landCommand) throws InvalidArgumentException {
        String[] commandArr = landCommand.split(" ");
        try {
            this.rover = new Rover(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]), Enum.valueOf(Direction.class, commandArr[3]));
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentException(String.format("Invalid Argument Exception: %s", e.getMessage()));
        }
    }

    public void move(String command) throws CommandNotFoundException {
        this.command = CommandFactory.getCommand(command, rover);
        if (this.command == null) {
            throw new CommandNotFoundException(String.format("Undefined Command!: %s", command));
        } else {
            this.command.execute();
        }
    }

    public void processMoveCommand(String commandString) throws CommandNotFoundException {
        for (char ch : commandString.toCharArray()) {
            this.move(String.valueOf(ch));
        }
    }

    public String printStatus() {
        return this.rover.printStatus();
    }

    public Rover getRover() {
        return rover;
    }
}
