package Vehicles;

import Abstracts.IDirection;
import Abstracts.Movable;
import Machine.Engine;
import Machine.ITransportable;
import Machine.ITransportableByCarTransport;

import java.awt.*;

public class Volvo240 implements IDirection, ITransportableByCarTransport, ICar {

    private final int nrDoors = 4;
    private Engine engine = new Engine(100);
    private final static double trimFactor = 1.25;
    private Movable movable;
    private Vehicle vehicle;

    public Volvo240(double x, double y, Direction direction) {

        this.movable = new Movable(x, y, direction);
        this.vehicle = new Vehicle(Color.BLACK, "Volvo240");

    }

    //----------Methods----------

    public double speedFactor(){
        return engine.getEnginePower() * 0.01 * trimFactor;
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
        movable.setCurrentSpeed(engine.startEngine());
    }

    @Override
    public void stopEngine() {
        movable.setCurrentSpeed(engine.stopEngine());
    }

    @Override
    public int getNrDoors() {
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
        movable = newMovable;
    }

    @Override
    public void exitTransport(){
        movable = new Movable(movable.getX(), movable.getY(), Direction.SOUTH);
    }

    //----------Testing----------

    @Override
    public double getX(){
        return movable.getX();
    }

    @Override
    public double getY(){
        return movable.getY();
    }
}
