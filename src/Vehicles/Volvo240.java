package Vehicles;

import Machine.Engine;
import Machine.ITransportable;

import java.awt.*;

public class Volvo240 extends Vehicle implements ITransportable, ICar {

    private final int nrDoors = 4;
    private Engine engine = new Engine(100);
    private final static double trimFactor = 1.25;

    public Volvo240(double x, double y, Direction direction) {
        super(x, y, 12, direction, Color.BLACK, "Volvo240");
    }

    //----------Methods----------

    @Override
    public double speedFactor(){
        return engine.getEnginePower() * 0.01 * trimFactor;
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
    public int getNrDoors() {
        return nrDoors;
    }

    @Override
    public void isTransported(double x, double y) {
        setX(x);
        setY(y);
    }
}
