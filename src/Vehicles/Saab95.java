package Vehicles;

import Abstracts.IDirection;
import Abstracts.Movable;
import Machine.Engine;
import Machine.ITransportable;
import Vehicles.ICar;
import Vehicles.Vehicle;

import java.awt.*;
//extends Vehicle?
public class Saab95 implements IDirection, ITransportable, ICar {

    private final int nrDoors = 2;
    private Engine engine = new Engine(125);
    private boolean turboOn = false;
    private Vehicle vehicle;
    private Movable movable;


    public Saab95(double x, double y, Direction direction) {

        this.movable = new Movable(x, y, direction);
        this.vehicle = new Vehicle(Color.RED, "Saab95");
    }

    //----------Methods----------

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return engine.getEnginePower() * 0.01 * turbo;
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
    public int getNrDoors(){
        return nrDoors;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public void isTransported(double x, double y) {

}