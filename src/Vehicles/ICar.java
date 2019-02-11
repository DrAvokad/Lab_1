package Vehicles;

import Abstracts.Movable;
import Machine.ITransportable;

public interface ICar extends ITransportable {

    void gas(double amount);
    void brake(double amount);
    void startEngine();
    void stopEngine();
    int getNrDoors();
    void move();
    void turnLeft();
    void turnRight();

}
