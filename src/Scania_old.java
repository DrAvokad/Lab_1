import java.awt.*;

public class Scania_old extends Car{

    private double loadingPlatformAngle;

    public Scania_old (int x, int y, Direction direction){
        super(2,300, Color.blue,"Scania",x,y, direction);

        loadingPlatformAngle = 0;
        currentSpeed = 0;
    }

    //----------Methods----------

    @Override
    double speedFactor() {
        return enginePower * 0.003;
    }

    public void tiltLoadingPlatform (double amount) {
        if(currentSpeed == 0) {

            if (amount > 1) {
                amount = 1;
            } else if (amount < -1) {
                amount = -1;
            }
            loadingPlatformAngle = loadingPlatformAngle + 10 * amount;

            if (loadingPlatformAngle > 70) {
                loadingPlatformAngle = 70;
            } else if (loadingPlatformAngle < 0) {
                loadingPlatformAngle = 0;
            }
        }
    }

    @Override
    public void startEngine(){
        if(loadingPlatformAngle == 0) {
            currentSpeed = 0.1;
            engineOn = true;
        }
    }

    public double getLoadingPlatformAngle(){
        return this.loadingPlatformAngle;
    }
}
