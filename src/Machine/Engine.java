package Machine;

public class Engine {

    private boolean engineOn;
    private final double enginePower;

    public Engine(double enginePower){

        this.enginePower = enginePower;
        this.engineOn = false;
    }

    //----------Methods----------

    //----------Getters----------

    public boolean getEngineOn(){
        return this.engineOn;
    }

    public double getEnginePower(){
        return this.enginePower;
    }

    //----------Engine----------

    //abstract double speedFactor();

    public double startEngine(){
        double currentSpeed = 0.1;
        engineOn = true;
        return currentSpeed;
    }

    public double stopEngine(){
        double currentSpeed = 0;
        engineOn = false;
        return currentSpeed;
    }

    public double gas(double amount, double currentSpeed, double speedFactor){
        double newSpeed = 0;
        if (engineOn) {
            if (amount <= 0) {
                newSpeed = incrementSpeed(0, currentSpeed, speedFactor);
            } else if (amount > 1) {
                newSpeed = incrementSpeed(1, currentSpeed, speedFactor);
            } else {
                newSpeed = incrementSpeed(amount, currentSpeed, speedFactor);
            }
        }
        if(currentSpeed > enginePower){
            return enginePower;
        }else{
            return newSpeed;
        }
    }

    public double brake(double amount, double currentSpeed, double speedFactor){
        double newSpeed = 0;
        if (engineOn) {
            if (amount <= 0) {
                newSpeed = decrementSpeed(0, currentSpeed, speedFactor);
            } else if (amount > 1) {
                newSpeed = decrementSpeed(1, currentSpeed, speedFactor);
            } else {
                newSpeed = decrementSpeed(amount, currentSpeed, speedFactor);
            }
        }
        if(currentSpeed < 0){
            return 0;
        }else{
            return newSpeed;
        }
    }

    //----------Helper Methods----------

    private double incrementSpeed(double amount, double currentSpeed, double speedFactor) {
        double incrementedSpeed = currentSpeed + speedFactor * amount;
        return incrementedSpeed;
    }

    private double decrementSpeed(double amount, double currentSpeed, double speedFactor) {
        double incrementedSpeed = currentSpeed - speedFactor * amount;
        return incrementedSpeed;
    }

}
