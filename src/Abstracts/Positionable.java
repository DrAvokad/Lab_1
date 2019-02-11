package Abstracts;

public class Positionable implements IPositionable{

    private double x;
    private double y;

    public Positionable(double x, double y){

        this.x = x;
        this.y = y;

    }

    //----------Methods----------

    //----------Getters----------

    @Override
    public double getX(){
        return this.x;
    }

    @Override
    public double getY(){
        return this.y;
    }

    //----------Setters----------

    @Override
    public void setX(double x){
        this.x = x;
    }

    @Override
    public void setY(double y){
        this.y = y;
    }

}
