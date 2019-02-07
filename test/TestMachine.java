import Abstracts.Movable;
import Vehicles.TestCar;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMachine {

    //----------Engine----------

    @Test
    public void testCarCurrentSpeedatInit(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        assertTrue(testCar.getCurrentSpeed()==0);
    }

    @Test
    public void testCarCurrentSpeedStartedEngine(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        testCar.startEngine(testCar.getCurrentSpeed());
        assertTrue(testCar.getCurrentSpeed()==0.1);
    }

    @Test
    public void testCarEngineOff(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        assertFalse(testCar.getEngineOn());
    }

    @Test
    public void testCarEngineOn(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        testCar.startEngine(testCar.getCurrentSpeed());
        assertTrue(testCar.getEngineOn());
    }

    @Test
    public void testCarGasEngineOff(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        testCar.gas(1);
        assertTrue(testCar.getCurrentSpeed()==0);
    }

    @Test
    public void testCarGasEngineOnAmount1(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        testCar.startEngine(testCar.getCurrentSpeed());
        testCar.gas(1);
        assertTrue(testCar.getCurrentSpeed()==1.1);
    }

    @Test
    public void testCarGasEngineOnAmountHalf(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH);
        testCar.startEngine(testCar.getCurrentSpeed());
        testCar.gas(0.5);
        assertTrue(testCar.getCurrentSpeed()==0.6);
    }

    //----------Loadable----------


}
