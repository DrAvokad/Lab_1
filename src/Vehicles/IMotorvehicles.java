package Vehicles;

import Machine.ITransportable;

public interface IMotorvehicles extends ITransportable {

    void gas(double amount);
    void brake(double amount);
    void startEngine();
    void stopEngine();
    void move();
    void turnLeft();
    void turnRight();
}
