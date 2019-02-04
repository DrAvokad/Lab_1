public interface ISpeedControl {

    double speedFactor();
    void gas(double amount);
    void brake(double amount);
}
