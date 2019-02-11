package Vehicles;

import Machine.ITransportable;

public interface ITruck extends ITransportable {

    void gas(double amount);
    void brake(double amount);
    void startEngine();
    void stopEngine();
    int getDoors();
    void move();
    void turnLeft();
    void turnRight();

}
