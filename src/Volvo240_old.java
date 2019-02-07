import java.awt.*;

public class Volvo240_old extends Car implements ISpeedControl{

    private final static double trimFactor = 1.25;

    //----------Constructor----------

    public Volvo240_old(int x, int y, Direction direction){
        super(4, 100, Color.black, "Volvo240", x, y, direction);
    }

    //----------Methods----------

    /**
     * Använder sig av enginePower och värdet av trimFactor för att returnera ett värde som sedan kan användas för
     * att avgöra hur mycket currentSpeed ska ändras när man kallar på metoden gas eller brake.
     * @return
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Använder sig av värdet man får ut av speedFactor och ett givet värde för att öka Volvo240-objektets currentSpeed.
     * @param amount
     */
}
