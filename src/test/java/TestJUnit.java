import com.demo.rover.remotecontrol.boundary.Direction;
import com.demo.rover.remotecontrol.boundary.RemoteControlUnit;
import com.demo.rover.remotecontrol.exception.CommandNotFoundException;
import com.demo.rover.remotecontrol.exception.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Test;

public class TestJUnit {

    @Test
    public void testInitialize() {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        Assert.assertEquals(this.printStatus(x, y, direction), remoteControlUnit.getRover().printStatus());
    }

    @Test
    public void testInitializeWithLandCommand() throws CommandNotFoundException, InvalidArgumentException {
        String landCommand = "START 2 0 EAST";
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(landCommand);
        Assert.assertEquals(this.printStatus(2, 0 , Direction.EAST), remoteControlUnit.printStatus());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testInitializeWithInvalidCoordinate() throws CommandNotFoundException, InvalidArgumentException {
        String landCommand = "START A 0 EAST";
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(landCommand);
        Assert.assertEquals(this.printStatus(2, 0 , Direction.EAST), remoteControlUnit.printStatus());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testInitializeWithInvalidDirection() throws CommandNotFoundException, InvalidArgumentException {
        String landCommand = "START 2 0 ASD";
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(landCommand);
        Assert.assertEquals(this.printStatus(2, 0 , Direction.EAST), remoteControlUnit.printStatus());
    }

    @Test(expected = CommandNotFoundException.class)
    public void testWhenCommandNotFound() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("X");
    }

    @Test(expected = CommandNotFoundException.class)
    public void testWhenCommandNull() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move(null);
    }

    @Test
    public void testMoveMultiCommand() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.processMoveCommand("FF");
        Assert.assertEquals(this.printStatus(x + 2, y, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveForwardEast() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("F");
        Assert.assertEquals(this.printStatus(x + 1, y, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveForwardWest() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.WEST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("F");
        Assert.assertEquals(this.printStatus(x - 1, y, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveForwardNorth() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.NORTH;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("F");
        Assert.assertEquals(this.printStatus(x, y + 1, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveForwardSouth() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.SOUTH;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("F");
        Assert.assertEquals(this.printStatus(x, y - 1, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveBackwardEast() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.EAST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("B");
        Assert.assertEquals(this.printStatus(x - 1, y, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveBackwardWest() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.WEST;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("B");
        Assert.assertEquals(this.printStatus(x + 1, y, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveBackwardNorth() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.NORTH;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("B");
        Assert.assertEquals(this.printStatus(x, y - 1, direction), remoteControlUnit.printStatus());
    }

    @Test
    public void testMoveBackwardSouth() throws CommandNotFoundException {
        int x = 3;
        int y = 5;
        Direction direction = Direction.SOUTH;
        RemoteControlUnit remoteControlUnit = new RemoteControlUnit(x, y, direction);
        remoteControlUnit.move("B");
        Assert.assertEquals(this.printStatus(x, y + 1, direction), remoteControlUnit.printStatus());
    }

    public String printStatus(int x, int y, Direction direction) {
        return "(" + x + ", " + y + ") " + direction.name();
    }
}
