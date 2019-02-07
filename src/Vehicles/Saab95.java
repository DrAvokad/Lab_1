package Vehicles;

import Machine.Engine;
import Machine.ITransportable;
import Vehicles.ICar;
import Vehicles.Vehicle;

import java.awt.*;

public class Saab95 extends Vehicle implements ITransportable, ICar {

    private final int nrDoors = 2;
    private Engine engine = new Engine(125);
    private boolean turboOn = false;

    public Saab95(double x, double y, Direction direction) {
        super(x, y, 10, direction, Color.RED, "Saab95");

    }

    //----------Methods----------

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return engine.getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void gas(double amount) {
        setCurrentSpeed(engine.gas(amount, getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void brake(double amount) {
        setCurrentSpeed(engine.brake(amount, getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void startEngine() {
        setCurrentSpeed(engine.startEngine());

    }

    @Override
    public void stopEngine() {
        setCurrentSpeed(engine.stopEngine());
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

}
