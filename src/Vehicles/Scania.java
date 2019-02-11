package Vehicles;

import Abstracts.IDirection;
import Abstracts.Movable;
import Machine.Engine;
import Machine.ITransportable;

import java.awt.*;

public class Scania implements IDirection, ITransportable, ITruck {

    private Engine engine = new Engine(300);
    private final int nrDoors = 2;
    private double flatBedAngle = 0;
    private Movable movable;
    private Vehicle vehicle;

    public Scania(double x, double y, Direction direction) {

        this.movable = new Movable(x, y, direction);
        this.vehicle = new Vehicle(Color.BLUE, "Scania");

    }


    //----------Methods----------

    public double speedFactor() {
        return engine.getEnginePower() * 0.003;
    }

    @Override
    public void gas(double amount) {
        if(flatBedAngle == 0){
            movable.setCurrentSpeed(engine.gas(amount, movable.getCurrentSpeed(), speedFactor()));
        }
    }

    @Override
    public void brake(double amount) {
        movable.setCurrentSpeed(engine.brake(amount, movable.getCurrentSpeed(), speedFactor()));
    }

    @Override
    public void startEngine() {
        if(flatBedAngle == 0){
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

    public void tiltLoadingPlatform (double amount) {
        if(movable.getCurrentSpeed() == 0) {

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

    @Override
    public void transport(Movable newMovable) {
        movable = newMovable;
    }

    @Override
    public void exitTransport(){
        movable = new Movable(movable.getX(), movable.getY(), Direction.SOUTH);
    }

    //----------Testing----------

    public double getX(){
        return movable.getX();
    }

    public double getY(){
        return movable.getY();
    }

}
