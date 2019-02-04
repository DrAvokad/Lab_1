import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;

public class Saab95 extends Car implements ISpeedControl{

    private boolean turboOn;

    //----------Constructor----------

    public Saab95(int x, int y, Direction direction){
        super(2,125, Color.red,"Saab95",x,y, direction);
        turboOn = false;

    }

    //----------Methods----------

    /**
     * Sätter boolean-värdet turboOn till true vilket kommer påverka speedFactor hos ett Saab95-objekt.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Sätter boolean-värdet turboOn till false vilket kommer påverka speedFactor hos ett Saab95-objekt.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Returnerar boolean-värdet hos variablen turboOn.
     * @return
     */
    public boolean getTurbo(){
        return turboOn;
    }

    /**
     * Använder sig av enginePower och boolean-värdet av turboOn för att returnera ett värde som sedan kan användas för
     * att avgöra hur mycket currentSpeed ska ändras när man kallar på metoden gas eller brake.
     * @return
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
