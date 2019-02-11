import Abstracts.IDirection;
import Buildings.Workshop;
import Other.Ekollon;
import Vehicles.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class TestObjects {

    @Test
    public void testWorkshopStatic(){
        Workshop workshop = new Workshop<>(0, 0, 8, new ArrayList(8), "Workshoppe");
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
        Workshop<Volvo240> workshop = new Workshop(0, 0, 8, new ArrayList(8), "Workshoppe");
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

    @Test
    public void testCarTransportMaxTransportandTestRange(){
        CarTransport carTransport = new CarTransport(0, 0, IDirection.Direction.EAST);
        Volvo240 rishögen = new Volvo240(50,50, IDirection.Direction.NORTH);
        Volvo240 rolfsKärra = new Volvo240(0,0, IDirection.Direction.NORTH);
        carTransport.operatePlatform();
        ICar[] list = new ICar[8];
        for (int i = 0; i < 8; i++){
            list[i] = new Saab95(0,0, IDirection.Direction.NORTH);
        }
        for (int i = 0; i < 8; i++){
            carTransport.load(list[i]);
        }
        carTransport.load(rolfsKärra);
        out.println(carTransport.getSize());
        out.println(carTransport.getCar(7));
        //out.println(carTransport.getCar(8));
        carTransport.unload();
        carTransport.unload();
        out.println(carTransport.getSize());
        carTransport.load(rishögen);
        out.println(carTransport.getSize());

    }

//----------Workshop----------

    @Test
    public void testAddSaabToVolvoWorkshopStatic(){
        Workshop<Volvo240> workshop = new Workshop<Volvo240>(0, 0, 2, new ArrayList<Volvo240>(2), "shop");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        //workshop.load(saab95);
    }

    @Test
    public void testAddSaabCarToWorkshop (){
        Workshop<ICar> workshop = new Workshop<ICar>(0, 0, 2, new ArrayList<ICar>(2), "shop");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        workshop.load(saab95);
        assertTrue(workshop.getCar(0).equals(saab95));
    }

    @Test
    public void testAddVolvoCarToVolvoWorkshop (){
        Workshop<Volvo240> workshop = new Workshop<Volvo240>(0, 0, 2, new ArrayList<Volvo240>(2), "shop");
        workshop.openWorkshop();
        Volvo240 volvo240 = new Volvo240(0, 0 , IDirection.Direction.NORTH);
        workshop.load(volvo240);
        assertTrue(workshop.getCar(0).equals(volvo240));
    }

    @Test
    public void testAddCarToFullWorkshop(){
        Workshop<ICar> workshop = new Workshop<>(0, 0, 1, new ArrayList<>(1), "shop");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        Volvo240 volvo240 = new Volvo240(0,0, IDirection.Direction.EAST);
        workshop.load(saab95);
        workshop.load(volvo240);
        assertTrue(workshop.getSize() == 1);
    }

    @Test
    public void testUnloadCarFromWorkshop (){
        Workshop workshop = new Workshop<>(0, 0, 2, new ArrayList<>(2), "shop");
        workshop.openWorkshop();
        Saab95 saab95 = new Saab95(0, 0 , IDirection.Direction.NORTH);
        Volvo240 volvo240 = new Volvo240(0,0, IDirection.Direction.EAST);
        workshop.load(saab95);
        workshop.load(volvo240);
        workshop.unload();
        assertTrue(workshop.getSize() == 1);
    }

    //----------Scania----------

    @Test
    public void testMoveEastScania (){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        scania.startEngine();
        scania.gas(1);
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() > 0);
    }

    @Test
    public void testMoveSouthScania(){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        scania.startEngine();
        scania.gas(1);
        scania.turnRight();
        scania.move();
        assertTrue(scania.getY() > 0 && scania.getX() == 0);
    }

    @Test
    public void testMoveNorth(){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.move();
        assertTrue(scania.getY() < 0 && scania.getX() == 0);
    }

    @Test
    public void testMoveWest(){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        scania.startEngine();
        scania.gas(1);
        scania.turnLeft();
        scania.turnLeft();
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() < 0);
    }

    @Test
    public void testMoveEastSouthWest(){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
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
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
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
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        scania.gas(1);
        scania.move();
        assertTrue(scania.getY() == 0 && scania.getX() == 0);

    }

    @Test
    public void testStopEngine(){
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
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
        Scania scania = new Scania(0, 0, IDirection.Direction.SOUTH);
        assertTrue(scania.getDoors() == 2);
    }

}

