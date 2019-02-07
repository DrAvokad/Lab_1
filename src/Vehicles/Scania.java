package Vehicles;

import Machine.Engine;
import Machine.ITransportable;

import java.awt.*;

public class Scania extends Vehicle implements ITransportable, ITruck {

    private Engine engine = new Engine(300);
    private final int nrDoors = 2;
    private double flatBedAngle = 0;

    public Scania(double x, double y, Direction direction) {
        super(x, y, 50, direction, Color.BLUE, "Scania");
    }

    //----------Methods----------

    @Override
    double speedFactor() {
        return engine.getEnginePower() * 0.003;
    }

    @Override
    public void gas(double amount) {
        if(flatBedAngle == 0){
            setCurrentSpeed(engine.gas(amount, getCurrentSpeed(), speedFactor()));
        }
    }

    @Override
    public void brake(double amount) {
        setCurrentSpeed(engine.brake(amount, getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void startEngine() {
        if(flatBedAngle == 0){
            setCurrentSpeed(engine.startEngine());
        }
    }

    @Override
    public void stopEngine() {
        setCurrentSpeed(engine.stopEngine());
    }

    @Override
    public int getDoors() {
        return 0;
    }

    public void tiltLoadingPlatform (double amount) {
        if(getCurrentSpeed() == 0) {

            if (amount > 1) {
                amount = 1;
            } else if (amount < -1) {
                amount = -1;
            }
            flatBedAngle = flatBedAngle + 10 * amount;

            if (flatBedAngle > 70) {
                flatBedAngle = 70;
            } else if (flatBedAngle < 0) {
                flatBedAngle = 0;
            }
        }
    }
}
