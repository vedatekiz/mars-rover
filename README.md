# Mars Rover Kata

## Task Description

This is an idiomatic piece of software that translates the commands sent from earth to actions executed by the rover yielding a final state on the Mars surface.

The project is a standalone console application that inputs coordinates `x`, `y` and a facing direction.

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

 Usage 
-----------
* To land the rover on the surface with the desired coordinates and facing direction, simply type `START x y Dimension` on the console.
* `x and y` are positive integers 
* `Dimension` is one of NORTH, SOUTH, EAST and WEST
* Input format for the move is `F`, as many as you want.
* To quit the application, type `QUIT` on the console

Build & Run
-----------
* `mvn package` should handle the packaging and produce the jar file on the target directory. `java -jar generatedjarfile` should do the rest.

                        `Version: 1.2`
