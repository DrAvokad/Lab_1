import Abstracts.IDirection;
import Buildings.Workshop;
import Other.Ekollon;
import Vehicles.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class TestObjects {

    Scania scania;

    @Before
    public void init(){
        scania = new Scania(0,0, IDirection.Direction.EAST);
    }

    @Test
    public void testWorkshopStatic(){
        Workshop<ICar> workshop = new Workshop<>(0, 0, 8, new ArrayList<>(8), "Workshoppe");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        workshop.load(saab95);
        Ekollon ekollon = new Ekollon(1, 1);
       // workshop.load(ekollon);
        Scania scania = new Scania(1, 1, IDirection.Direction.NORTH);
       // workshop.load(scania);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.NORTH);
        workshop.load(volvo240);
    }

    @Test
    public void testCarTransportDrive(){
        CarTransport carTransport = new CarTransport(0, 0, IDirection.Direction.SOUTH);
        carTransport.turnLeft();
        carTransport.startEngine();
        for (int i = 0; i < 4; i++){
            carTransport.gas(1);
        }
        carTransport.move();
        //out.println(carTransport.getX());
        assertTrue(carTransport.getX() == 42.1);
    }

    @Test
    public void testCarTransportDriveOpened(){
        CarTransport carTransport = new CarTransport(0, 0, IDirection.Direction.SOUTH);
        carTransport.operatePlatform();
        carTransport.startEngine();
        for (int i = 0; i < 4; i++){
            carTransport.gas(1);
        }
        carTransport.move();
        //out.println(carTransport.getX());
        assertTrue(carTransport.getX() == 0);
    }

    @Test
    public void testWorkshopStaticDifferentCars(){
        Workshop<Volvo240> workshop = new Workshop<>(0, 0, 8, new ArrayList<>(8), "Workshoppe");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        //workshop.load(saab95);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.NORTH);
        workshop.load(volvo240);
    }

    @Test
    public void testCarTransportLoadSomeCarsClosed(){
        CarTransport carTransport = new CarTransport(0,0, IDirection.Direction.SOUTH);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.SOUTH);
        carTransport.load(volvo240);
        out.println(carTransport.getCar(0));
        //out.println(carTransport.getCar(1));
    }

    @Test
    public void testCarTransportLoadSomeCarsOpen(){
        CarTransport carTransport = new CarTransport(0,0, IDirection.Direction.SOUTH);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.SOUTH);
        carTransport.operatePlatform();
        carTransport.load(volvo240);
        out.println(carTransport.getCar(0));
        //out.println(carTransport.getCar(1));
    }

    @Test
    public void testCarTransportTransportSomeCars(){
        CarTransport carTransport = new CarTransport(0,0, IDirection.Direction.SOUTH);
        Volvo240 volvo240 = new Volvo240(0, 0, IDirection.Direction.SOUTH);
        Saab95 saab95 = new Saab95(0, 0, IDirection.Direction.NORTH);
        carTransport.operatePlatform();
        carTransport.load(volvo240);
        carTransport.load(saab95);
        carTransport.operatePlatform();
        carTransport.startEngine();
        for (int i = 0; i < 4; i++){
            carTransport.gas(1);
        }
        carTransport.move();
        carTransport.turnLeft();
        carTransport.move();
        carTransport.stopEngine();
        carTransport.operatePlatform();
        carTransport.unload();
        out.println(carTransport.getX());
        out.println(carTransport.getY());
        carTransport.operatePlatform();
        carTransport.startEngine();
        for (int i = 0; i < 4; i++){
            carTransport.gas(1);
        }
        carTransport.move();
        carTransport.stopEngine();
        carTransport.operatePlatform();
        carTransport.unload();
        out.println(carTransport.getX());
        out.println(carTransport.getY());
        assertTrue(carTransport.getX()==84.2 && carTransport.getY()==42.1 && saab95.getX() == 42.1 && saab95.getY() == 42.1 && volvo240.getX() == 84.2 && volvo240.getY() == 42.1);
        out.println(carTransport.getSize());
    }






    // Scania tester

    @Test
    public void testSpeedFactorScania(){
        assertTrue(scania.speedFactor() == (300 * 0.003));
    }

    @Test
    public void testMoveEastScania (){
        scania.startEngine();
        scania.gas(1);
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() > 0);
    }

    @Test
    public void testMoveSouthScania(){
        scania.startEngine();
        scania.gas(1);
        scania.turnRight();
        scania.move();
        assertTrue(scania.getY() > 0 && scania.getX() == 0);
    }

    @Test
    public void testMoveNorth(){

        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.move();
        assertTrue(scania.getY() < 0 && scania.getX() == 0);
    }

    @Test
    public void testMoveWest(){

        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.turnLeft();
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() < 0);
    }

    @Test
    public void testMoveEastSouthWest(){

        scania.startEngine();
        scania.gas(1);
        scania.move();
        scania.turnRight();
        scania.move();
        scania.turnRight();
        scania.move();
        assertTrue(scania.getY() > 0 && scania.getX() == 0);
    }


    @Test
    public void testMoveTurnleftTurnLeftUpaAndRightTwice(){

        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.turnLeft();
        scania.move();
        scania.turnRight();
        scania.move();
        scania.turnRight();
        scania.move();
        scania.move();
        assertTrue(scania.getY() < 0 && scania.getX() > 0);
    }

    @Test
    public void testMoveWithoutStartingEngine(){
        scania.gas(1);
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() == 0);

    }

    @Test
    public void testStopEngine(){

        scania.startEngine();
        scania.gas(1);
        scania.move();
        scania.turnRight();
        scania.stopEngine();
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() > 0);

    }

    @Test
    public void testNumberDoors(){

        assertTrue(scania.getDoors() == 2);
    }



}
