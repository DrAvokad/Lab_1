package Other;

import Abstracts.IPositionable;
import Abstracts.Positionable;

public class Ekollon implements IPositionable {

    private Positionable position;

    public Ekollon (double x, double y){

        this.position = new Positionable(x, y);
    }

    @Override
    public double getX() {
        return position.getX();
    }

    @Override
    public double getY() {
        return position.getY();
    }

    @Override
    public void setX(double x) {
        position.setX(x);
    }

    @Override
    public void setY(double y) {
        position.setY(y);
    }
}
