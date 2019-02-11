package Vehicles;

import Abstracts.IDirection;
import Abstracts.Movable;
import Machine.Engine;
import Machine.ICarCarrier;
import Machine.ITransportable;
import Machine.Loadable;

import java.awt.*;
import java.util.ArrayList;

public class CarTransport implements IDirection, ITransportable, ICarCarrier, ITruck {

    private final int nrDoors = 2;
    private Movable movable;
    private Vehicle vehicle;
    private Loadable<ICar> loadingPlatform;
    private Engine engine = new Engine(350);

    public CarTransport(double x, double y, Direction direction) {

        this.movable = new Movable(x, y, direction);
        this.vehicle = new Vehicle(Color.BLACK, "CarTransport");
        this.loadingPlatform = new Loadable<>(8, 10, false, new ArrayList<ICar>());
    }

    double speedFactor() {
        return 0.03 * engine.getEnginePower();
    }


    @Override
    public void load(ICar cargo) {
        loadingPlatform.load(cargo, movable, movable.getX(), movable.getY());
    }

    @Override
    public ICar unload() {
        return loadingPlatform.unload();
    }

    @Override
    public void gas(double amount) {
        movable.setCurrentSpeed(engine.gas(amount, movable.getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void brake(double amount) {
        movable.setCurrentSpeed(engine.brake(amount, movable.getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void startEngine() {
        if(!loadingPlatform.isOpen()){
                movable.setCurrentSpeed(engine.startEngine());
        }
    }

    @Override
    public void stopEngine() {
        movable.setCurrentSpeed(engine.stopEngine());
    }

    @Override
    public int getDoors() {
        return nrDoors;
    }

    @Override
    public void move() {
        movable.move();
    }

    @Override
    public void turnLeft() {
        movable.turnLeft();
    }

    @Override
    public void turnRight() {
        movable.turnRight();
    }

    @Override
    public void transport(Movable newMovable) {

    }

    public void operatePlatform(){
        if(loadingPlatform.isOpen()){
            loadingPlatform.close();
        }else if(movable.getCurrentSpeed()==0 && !loadingPlatform.isOpen()){
            loadingPlatform.open();
        }
    }

    @Override
    public void exitTransport(){
        movable = new Movable(movable.getX(), movable.getY(), Direction.SOUTH);
    }

    //----------For Testing----------

    public double getX(){
        return movable.getX();
    }

    public double getY(){
        return movable.getY();
    }

    public ICar getCar(int i){
        return loadingPlatform.getCargo(i);
    }

    public int getSize(){
        return loadingPlatform.getSize();
    }
}
