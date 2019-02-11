import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Testing {

    @Test
    public void testSaab95getNrDoors(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        assertTrue(saab.getNrDoors()==2);
    }

    @Test
    public void testVolvo240getNrDoors(){
        Volvo240 volvo = new Volvo240(20, 0, Car.Direction.EAST);
        assertTrue(volvo.getNrDoors()==4);
    }

    @Test
    public  void testTurnLeftSab(){
        Saab95 saab95 = new Saab95(0, 0, Car.Direction.NORTH);
        saab95.turnLeft();
        assertTrue(saab95.direction == Car.Direction.WEST);
    }


    @Test
    public  void testTurnRightVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.SOUTH);
        volvo240.turnRight();
        assertTrue(volvo240.direction == Car.Direction.WEST);
    }


    @Test
    public void testSaabEnginePower(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        assertTrue(saab.getEnginePower()==125);
    }


    @Test
    public void testCurrentSpeedVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.NORTH);
        assertTrue(volvo240.getCurrentSpeed()==0);
    }


    @Test
    public void testSaabColor(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        assertTrue(saab.getColor()== Color.red);
    }

    /*
    @Test
    public void testSetColorVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.NORTH);
        volvo240.setColor(Color.pink);
        assertTrue(volvo240.getColor()== Color.pink );
    }
    */

    @Test
    public void testSaabStartEngine(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed()== 0.1);
    }


    @Test
    public void testStopEngineVolvo(){
        Volvo240 volvo240 = new Volvo240(0, 0, Car.Direction.NORTH);
        volvo240.startEngine();
        volvo240.stopEngine();
        assertTrue(volvo240.getCurrentSpeed()== 0 );
    }


    /*@Test
    public void testSaabIncrementSpeed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.incrementSpeed(100);
        assertTrue(saab.getCurrentSpeed()== 125);
    }


    @Test
    public void testSaabDecrementSpeed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.decrementSpeed(100);
        assertTrue(saab.getCurrentSpeed()== -125);
    }
*/

    @Test
    public void testSaabTurboOn(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.SOUTH);
        saab.setTurboOn();
        assertTrue(saab.getTurbo());
    }

    @Test
    public void testSaabTurboOff(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.SOUTH);
        saab.setTurboOn();
        saab.setTurboOff();
        assertTrue(!saab.getTurbo());
    }

    @Test
    public void testSpeedFactorSaabTurboOff(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        assertTrue(saab.speedFactor() == 1.25);
    }

    @Test
    public void testSpeedFactorSaabTurboOn(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);
    }

    @Test
    public void testSpeedFactorVolvo240(){
        Volvo240 volvo = new Volvo240(0, 0, Car.Direction.NORTH);
        assertTrue(volvo.speedFactor()==1.25);
    }

    @Test
    public void testSetCurrentSpeed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.startEngine();
        saab.setCurrentSpeed(100);
        assertTrue(saab.getCurrentSpeed()==100);
        }

    @Test
    public void testSaab95GasValue1OnceEngineStartedTurboOff(){
        Saab95 saab = new Saab95(0 ,0 , Car.Direction.NORTH);
        saab.startEngine();
        saab.gas(1);
        assertTrue(saab.getCurrentSpeed()==1.35);
        }

    @Test
    public void testSaab95GasValue1OnceEngineStartedTurboOn(){
        Saab95 saab = new Saab95(0 ,0 , Car.Direction.NORTH);
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(1);
        assertTrue(saab.getCurrentSpeed()==1.725);
    }

    @Test
    public void testSaab95GasValueZeroPointFiveOnceEngineStartedTurboOff(){
        Saab95 saab = new Saab95(0 ,0 , Car.Direction.NORTH);
        saab.startEngine();
        saab.gas(0.5);
        assertTrue(saab.getCurrentSpeed()==0.725);
    }

    @Test
    public void testSaab95GasValue0OnceEngineStartedTurboOff(){
        Saab95 saab = new Saab95(0 ,0 , Car.Direction.NORTH);
        saab.startEngine();
        saab.gas(0);
        assertTrue(saab.getCurrentSpeed()==0.1);
    }

    @Test
    public void testVolvo240BrakeValue1AtSpeed100(){
        Volvo240 volvo = new Volvo240(0 ,0 , Car.Direction.NORTH);
        volvo.setCurrentSpeed(100);
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed()==98.75);
    }

    @Test
    public void testVolvo240BrakeValue0AtSpeed100(){
        Volvo240 volvo = new Volvo240(0 ,0 , Car.Direction.NORTH);
        volvo.setCurrentSpeed(100);
        volvo.brake(0);
        assertTrue(volvo.getCurrentSpeed()==100);
    }

    @Test
    public void testVolvo240BrakeValueZeroPointFiveAtSpeed100(){
        Volvo240 volvo = new Volvo240(0 ,0 , Car.Direction.NORTH);
        volvo.setCurrentSpeed(100);
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed()==99.375);
    }

    @Test
    public void testVolvo240BrakeValue1AtSpeed0(){
        Volvo240 volvo = new Volvo240(0 ,0 , Car.Direction.NORTH);
        volvo.setCurrentSpeed(0);
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed()==0);
    }

    @Test
    public void testVolvo240GasValue1AtSpeed100(){
        Volvo240 volvo = new Volvo240(0 ,0 , Car.Direction.NORTH);
        volvo.setCurrentSpeed(100);
        volvo.gas(1);
        assertTrue(volvo.getCurrentSpeed()==100);
    }

    @Test
    public void testSaab95MoveAt0Speed(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.NORTH);
        saab.move();
        assertTrue(saab.getX()==0 && saab.getY()==0);
    }

    @Test
    public void testSaab95MoveEngineStarted(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.SOUTH);
        saab.startEngine();
        saab.move();
        assertTrue(saab.getY()==0);
    }

    @Test
    public void testSaab95MoveEngineStarted3Gas(){
        Saab95 saab = new Saab95(0, 0, Car.Direction.SOUTH);
        saab.startEngine();
        for(int i = 0;  i < 3; i++)
            saab.gas(1);
        saab.move();
        assertTrue(saab.getY()==3);
    }

    @Test
    public void testVolvo240MoveEngineStarted3GasCheckCurrentSpeed(){
        Volvo240 volvo = new Volvo240(0, 0, Car.Direction.SOUTH);
        volvo.startEngine();
        for(int i = 0;  i < 3; i++)
            volvo.gas(1);
        volvo.move();
        assertTrue(volvo.getCurrentSpeed()==3.85);
    }

    @Test
    public void testVolvo240TurnRightThenMove(){
        Volvo240 volvo = new Volvo240(0, 0, Car.Direction.NORTH);
        volvo.turnRight();
        volvo.setCurrentSpeed(10);
        volvo.move();
        assertTrue(volvo.getX()==10);
    }

    @Test
    public void testAddVolvoCarToCarGarage(){
        Volvo240 volvo = new Volvo240(0,0, Car.Direction.EAST);
        Garage<Car> garage = new Garage(2, new ArrayList<Car>());
        garage.addCar(volvo);
        assertTrue(garage.getCar(0).equals(volvo));
    }

    @Test
    public void testAddVolvoCarToVolvoGarage(){
        Volvo240 volvo = new Volvo240(0,0, Car.Direction.EAST);
        Garage<Volvo240> garage = new Garage(2, new ArrayList<Volvo240>());
        garage.addCar(volvo);
        assertTrue(garage.getCar(0).equals(volvo));
    }
/*
    @Test
    public void testAddVolvoCarToSaabGarage(){
        Volvo240 volvo = new Volvo240(0,0, Car.Direction.EAST);
        Garage<Saab95> garage = new Garage(2, new ArrayList<Saab95>());
        garage.addCar(volvo);
        assertTrue(garage.getCar(0).equals(volvo));
    }
*/

    @Test
    public void testAddCarToFullGarage(){
        Volvo240 volvo = new Volvo240(0,0, Car.Direction.EAST);
        Saab95 saab = new Saab95(0,0, Car.Direction.EAST);
        Garage<Car> garage = new Garage(1, new ArrayList<Car>());
        garage.addCar(volvo);
        garage.addCar(saab);
        assertTrue(garage.cars.size() == 1);
    }

    @Test
    public void testGetCarInformation(){
        Volvo240 volvo = new Volvo240(0,0, Car.Direction.EAST);
        Garage<Volvo240> garage = new Garage(1, new ArrayList<Volvo240>());
        garage.addCar(volvo);
        //assertTrue(garage.getCar(0) == );
    }

    //----------Part II----------

    //Scania

    @Test
    public void testScaniaTiltLoadingPlatform(){
        Scania scania = new Scania(0, 0, Car.Direction.NORTH);
        scania.tiltLoadingPlatform(1);
        assertTrue(scania.getLoadingPlatformAngle()==10);
    }

    @Test
    public void testScaniaTiltLoadingPlatformWhileMoving(){
        Scania scania = new Scania(0, 0, Car.Direction.NORTH);
        scania.startEngine();
        scania.gas(10);
        scania.tiltLoadingPlatform(1);
        assertTrue(scania.getLoadingPlatformAngle()==0);
    }

    @Test
    public void testScaniaStartEngineWithLoadingPlatformAngleNotAtZero(){
        Scania scania = new Scania(0,0, Car.Direction.NORTH);
        scania.tiltLoadingPlatform(1);
        scania.startEngine();
        assertFalse(scania.getEngineOn());
    }

    @Test
    public void testScaniaGasAfterLoadingPlatformRaised(){
        Scania scania = new Scania(0, 0, Car.Direction.NORTH);
        scania.tiltLoadingPlatform(1);
        scania.tiltLoadingPlatform(-1);
        scania.tiltLoadingPlatform(-1);
        scania.startEngine();
        scania.gas(1);
        assertTrue(scania.getCurrentSpeed()==1);
    }

    @Test
    public void testScaniaMaxLoadingPlatformAngle(){
        Scania scania = new Scania(0,0, Car.Direction.NORTH);
        for (int i = 0; i < 10; i++){
            scania.tiltLoadingPlatform(1);
        }
        assertTrue(scania.getLoadingPlatformAngle()==70);
    }

    @Test
    public void testScaniaMinLoadingPlatformAngle(){
        Scania scania = new Scania(0,0, Car.Direction.NORTH);
        for (int i = 0; i < 10; i++){
            scania.tiltLoadingPlatform(-1);
        }
        assertTrue(scania.getLoadingPlatformAngle()==0);
    }
}

