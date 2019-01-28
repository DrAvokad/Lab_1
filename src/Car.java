import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    protected int x;
    protected int y;
    protected Direction direction;

    protected enum Direction {
        FORWARD, BACKWARD, LEFT, RIGHT
    }

    /**
     * metoden är en constructor för att ange alla variabler
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param x
     * @param y
     * @param direction
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int x, int y, Direction direction){

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y, Direction direction){

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = direction;

        this.currentSpeed = 0;
    }

    public void move() {
        if(direction == Direction.FORWARD){
            y = y + (int)currentSpeed;
        }else if(direction == Direction.BACKWARD){
            y = y - (int)currentSpeed;
        }else if (direction == Direction.RIGHT){
            x = x + (int)currentSpeed;
        }else if (direction == Direction.LEFT){
            x = x - (int)currentSpeed;
        }
    }


    public void turnLeft() {
        if(direction == Direction.FORWARD){
            direction = Direction.LEFT;
        }else if(direction == Direction.BACKWARD){
            direction = Direction.RIGHT;
        }else if (direction == Direction.RIGHT){
            direction = Direction.FORWARD;
        }else if (direction == Direction.LEFT){
            direction = Direction.BACKWARD;
        }
    }

    public void turnRight() {
        if(direction == Direction.FORWARD){
            direction = Direction.RIGHT;
        }else if(direction == Direction.BACKWARD){
            direction = Direction.LEFT;
        }else if (direction == Direction.RIGHT){
            direction = Direction.BACKWARD;
        }else if (direction == Direction.LEFT) {
            direction = Direction.FORWARD;
        }
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
