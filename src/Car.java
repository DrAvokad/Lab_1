import java.awt.*;

public abstract class Car implements Movable {

    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName;
    protected int x;
    protected int y;
    protected Direction direction;

    protected enum Direction {
        FORWARD, BACKWARD, LEFT, RIGHT
    }

    /**
     * Metoden är konstruktorn som används för att skapa ett objekt av denna klassen. currentSpeed anges ej utan
     * initialiseras med värdet 0.
     * @param nrDoors - Hur många dörrar den skapade bilen har.
     * @param enginePower - En double som kommer avgöra hur snabbt en bil kan accelerera.
     * @param color - Den skapade bilens färg. Går att ändra senare med en setter.
     * @param modelName - Namnet på bilmodellen.
     * @param x - Bilens nuvarande position i x-led.
     * @param y - Bilens nuvarande position i y-led.
     * @param direction - Beroende på vilket värde direction har så kommer det påverka hur bilen förflyttas när move
     *                  kallas över bilen.
     */
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

    /**
     * Förflyttar bilobjektet i x- eller y-led beroende på vilket värde direction har. Hur mycket bilobjektet förflyttas
     * vid varje kall av move avgörs av värdet på currentSpeed.
     */
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

    /**
     * Ändrar värdet på direction "ett steg åt vänster" från dess nuvarande värde.
     */
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

    /**
     * Ändrar värdet på direction "ett steg åt höger" från dess nuvarande värde.
     */
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

    /**
     * Returnerar antalet dörrar ett bilobjekt har.
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returnerar värdet på enginePower hos ett bilobjekt.
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returnerar värdet på currentSpeed hos ett bilobjekt.
     * @return
     */
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
