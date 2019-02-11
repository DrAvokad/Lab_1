import java.awt.*;

public abstract class Car {

    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName;
    protected int x;
    protected int y;
    protected Direction direction;
    protected boolean engineOn;

    protected enum Direction {
        NORTH, SOUTH, WEST, EAST
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
        this.engineOn = false;
    }

    /**
     * Förflyttar bilobjektet i x- eller y-led beroende på vilket värde direction har. Hur mycket bilobjektet förflyttas
     * vid varje kall av move avgörs av värdet på currentSpeed.
     */
    public void move() {
        if(direction == Direction.NORTH){
            y = y - (int)currentSpeed;
        }else if(direction == Direction.SOUTH){
            y = y + (int)currentSpeed;
        }else if (direction == Direction.EAST){
            x = x + (int)currentSpeed;
        }else if (direction == Direction.WEST){
            x = x - (int)currentSpeed;
        }
    }

    /**
     * Ändrar värdet på direction "ett steg åt vänster" från dess nuvarande värde.
     */
    public void turnLeft() {
        if(direction == Direction.NORTH){
            direction = Direction.WEST;
        }else if(direction == Direction.SOUTH){
            direction = Direction.EAST;
        }else if (direction == Direction.EAST){
            direction = Direction.NORTH;
        }else if (direction == Direction.WEST){
            direction = Direction.SOUTH;
        }
    }

    /**
     * Ändrar värdet på direction "ett steg åt höger" från dess nuvarande värde.
     */
    public void turnRight() {
        if(direction == Direction.NORTH){
            direction = Direction.EAST;
        }else if(direction == Direction.SOUTH){
            direction = Direction.WEST;
        }else if (direction == Direction.EAST){
            direction = Direction.SOUTH;
        }else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
        }
    }

    /**
     * Getter för bilobjektets position i x-led.
     * @return
     */
    public int getX(){
        return this.x;
    }

    /**
     * Getter för bilobjektets position i y-led.
     * @return
     */
    public int getY(){
        return this.y;
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

    /**
     * Returnerar den nuvarande färgen på bilobjektet.
     * @return
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sätter bilobjektets currentSpeed till 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
        engineOn = true;
    }

    public boolean getEngineOn(){
        return engineOn;
    }

    /**
     * Sätter bilobjektets currentSpeed direkt till 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Endast för testing.
     * @param amount
     */

    public void setCurrentSpeed(double amount){
        currentSpeed = amount;
    }

    abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Använder sig av värdet man får ut av speedFactor och ett givet värde för att sänka Volvo240-objektets
     * currentSpeed.
     * @param amount
     */

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Använder sig av metoden incrementSpeed och ett angivet värde för att öka bilobjektets currentSpeed. Anges ett
     * värde mindre än 0 eller större än 1 kommer inte metoden göra något. Kallas metoden och det resulterar i att
     * currentSpeed blir högre än värdet på enginePower kommer currentSpeed sänkas till värdet av enginePower.
     * @param amount En double som ska ligga mellan 0 & 1 för att metoden ska göra något. Högre värde resulterar i att
     *               currentSpeed ökas mer.
     */

    /**
     * Använder sig av metoden incrementSpeed och ett angivet värde för att öka bilobjektets currentSpeed. Anges ett
     * värde mindre än 0 eller större än 1 kommer inte metoden göra något. Kallas metoden och det resulterar i att
     * currentSpeed blir högre än värdet på enginePower kommer currentSpeed sänkas till värdet av enginePower.
     * @param amount En double som ska ligga mellan 0 & 1 för att metoden ska göra något. Högre värde resulterar i att
     *               currentSpeed ökas mer.
     */

    public void gas(double amount){
        if ((amount < 0 || amount > 1) && engineOn){

        }else{
            incrementSpeed(amount);
        }
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }

    /**
     * Använder sig av metoden decrementSpeed och ett angivet värde för att sänka bilobjektets currentSpeed. Anges ett
     * värde mindre än 0 kommer det tolkas som 0.  Anges ett värde högre än 1 kommer det tolkas som 1. Kallas metoden
     * och det resulterar i att currentSpeed blir högre än värdet på enginePower kommer currentSpeed sänkas till värdet
     * av enginePower.
     * @param amount En double som ska ligga mellan 0 & 1 för att metoden ska göra något. Högre värde resulterar i att
     *               currentSpeed ökas mer.
     */

    public void brake(double amount){
        if (amount < 0){

        }else if(amount > 1){
            decrementSpeed(1);
        }else{
            decrementSpeed(amount);
        }
        if (currentSpeed < 0){
            currentSpeed = 0;
        }
    }
}
