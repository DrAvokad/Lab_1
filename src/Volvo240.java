import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    //public int nrDoors; // Number of doors on the car
    //public double enginePower; // Engine power of the car
    //public double currentSpeed; // The current speed of the car
    //public Color color; // Color of the car
    //public String modelName; // The car model name

    public Volvo240(int x, int y, Direction direction){
        super(4, 100, Color.black, "Volvo240", x, y, direction);
    }

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /*public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
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
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
*/
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Använder sig av värdet man får ut av speedFactor och ett givet värde för att sänka bilobjektets currentSpeed.
     * @param amount
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Använder sig av metoden incrementSpeed och ett angivet värde för att öka bilobjektets currentSpeed. Anges ett
     * värde mindre än 0 eller större än 1 kommer inte metoden göra något. Kallas metoden och det resulterar i att
     * currentSpeed blir högre än värdet på enginePower kommer currentSpeed sänkas till värdet av enginePower.
     * @param amount En double som ska ligga mellan 0 & 1 för att metoden ska göra något. Högre värde resulterar i att
     *               currentSpeed ökas mer.
     */

    public void gas(double amount){
        if (amount < 0 || amount > 1){

        }else{
            incrementSpeed(amount);
        }
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }

}
