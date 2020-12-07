package com.demo.rover.remotecontrol;

import com.demo.rover.remotecontrol.boundary.RemoteControlUnit;
import com.demo.rover.remotecontrol.boundary.State;
import com.demo.rover.remotecontrol.exception.CommandNotFoundException;
import com.demo.rover.remotecontrol.exception.InvalidArgumentException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RemoteControlUnit remoteControlUnit = null;

        System.out.println("Hello there. Type 'START x y Direction' to land the rover ");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.startsWith(State.START.name())) {
                try {
                    remoteControlUnit = new RemoteControlUnit(input);
                } catch (InvalidArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (State.QUIT.name().equals(input)) {
                break;
            } else {
                try {
                    remoteControlUnit.processMoveCommand(input);
                } catch (CommandNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(remoteControlUnit.printStatus());
            }
        }
    }
}
