package Abstracts;

public interface IMoveable {

    void move();
    void turnLeft();
    void turnRight();
    void setCurrentSpeed(double x);
    double getCurrentSpeed();
}
