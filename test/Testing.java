import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Testing {

    @Test
    public void testSaab95getNrDoors(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        assertTrue(saab.getNrDoors()==2);
    }

    @Test
    public void testVolvo240getNrDoors(){
        Volvo240 volvo = new Volvo240(20, 0, Car.Direction.RIGHT);
        assertTrue(volvo.getNrDoors()==4);
    }

  /*  @Test
    public void testMoveSaab95Forward(){
        Saab95 saab95 = new Saab95(0, 0, Car.Direction.FORWARD);
        assertTrue();
    }*/
  @Test
  public  void testTurnLeftSab(){
      Saab95 saab95 = new Saab95(0, 0, Car.Direction.FORWARD);
      saab95.turnLeft();
      assertTrue(saab95.direction == Car.Direction.LEFT);
  }


    @Test
    public  void testTurnRightVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.BACKWARD);
        volvo240.turnRight();
        assertTrue(volvo240.direction == Car.Direction.LEFT);
    }


    @Test
    public void testSaabEnginePower(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        assertTrue(saab.getEnginePower()==125);
    }


    @Test
    public void testCurrentSpeedVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.FORWARD);
        assertTrue(volvo240.getCurrentSpeed()==0);
    }


    @Test
    public void testSaabColor(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        assertTrue(saab.getColor()== Color.red);
    }

    @Test
    public void testSetColorVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.FORWARD);
        volvo240.setColor(Color.pink);
        assertTrue(volvo240.getColor()== Color.pink );
    }

    @Test
    public void testSaabStartEngine(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed()== 0.1);
    }


    @Test
    public void testStopEngineVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.FORWARD);
        volvo240.startEngine();
        volvo240.stopEngine();
        assertTrue(volvo240.getCurrentSpeed()== 0 );
    }


    @Test
    public void testSaabIncrementSpeed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        saab.incrementSpeed(100);
        assertTrue(saab.getCurrentSpeed()== 125);
    }


    @Test
    public void testSaabDecrementSpeed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.FORWARD);
        saab.decrementSpeed(100);
        assertTrue(saab.getCurrentSpeed()== -125);
    }

}
