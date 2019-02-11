import Abstracts.Movable;
import Machine.Loadable;
import Vehicles.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMachine {

    //----------Engine----------
/*
    @Test
    public void testCarCurrentSpeedatInit(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        assertTrue(testCar.getCurrentSpeed()==0);
    }

    @Test
    public void testCarCurrentSpeedStartedEngine(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        testCar.startEngine(testCar.getCurrentSpeed());
        assertTrue(testCar.getCurrentSpeed()==0.1);
    }

    @Test
    public void testCarEngineOff(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        assertFalse(testCar.getEngineOn());
    }

    @Test
    public void testCarEngineOn(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        testCar.startEngine(testCar.getCurrentSpeed());
        assertTrue(testCar.getEngineOn());
    }

    @Test
    public void testCarGasEngineOff(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        testCar.gas(1);
        assertTrue(testCar.getCurrentSpeed()==0);
    }

    @Test
    public void testCarGasEngineOnAmount1(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        testCar.startEngine(testCar.getCurrentSpeed());
        testCar.gas(1);
        assertTrue(testCar.getCurrentSpeed()==1.1);
    }

    @Test
    public void testCarGasEngineOnAmountHalf(){
        TestCar testCar = new TestCar(0,0,10, Movable.Direction.SOUTH, Color.BLUE);
        testCar.startEngine(testCar.getCurrentSpeed());
        testCar.gas(0.5);
        assertTrue(testCar.getCurrentSpeed()==0.6);
    }

    //----------Loadable----------

    @Test
    public void testLoadableLoad(){
        Loadable<ICar> loadable = new Loadable<>(20, 10, false);
        Saab95 saab95 = new Saab95(0, 0, Movable.Direction.SOUTH);
        Volvo240 volvo240 = new Volvo240(0 , 0, Movable.Direction.SOUTH);
        loadable.open();
        loadable.load(saab95, saab95.getSize());
        assertTrue(loadable.getCurrentLoad() == 1);
    }

    @Test
    public void testLoadableLoadTruckInCarTransport(){
        Loadable<ICar> loadable = new Loadable<>(20, 10, false);
        Saab95 saab95 = new Saab95(0, 0, Movable.Direction.SOUTH);
        Volvo240 volvo240 = new Volvo240(0 , 0, Movable.Direction.SOUTH);
        Scania scania = new Scania(0, 0, Movable.Direction.SOUTH);
        loadable.open();
        loadable.load(saab95, saab95.getSize());
        //loadable.load(scania, scania.getSize());
        assertTrue(loadable.getCurrentLoad() == 1);
    }
    */
}
