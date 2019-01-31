import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    //public int nrDoors; // Number of doors on the car
    //public double enginePower; // Engine power of the car
    //public double currentSpeed; // The current speed of the car
    //public Color color; // Color of the car
    //public String modelName; // The car model name

    public Saab95(int x, int y, Direction direction){
        super(2,125, Color.red,"Saab95",x,y, direction);
        turboOn = false;

    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurbo(){
        return turboOn;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /*public Saab95(){
        super(int nr)
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /*public int getNrDoors(){
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

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Använder sig av värdet man får ut av speedFactor och ett givet värde för att öka bilobjektets currentSpeed.
     * @param amount Värdet som avgör hur mycket currentSpeed ska öka.
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
        if (amount < 0) {

        }else if(amount > 1){
            incrementSpeed(1);
        }else{
            incrementSpeed(amount);
        }
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }

    public void brake(double amount){
        
    }

    /*
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
*/
}
