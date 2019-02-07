package Abstracts;

public abstract class Positionable {

    private double x;
    private double y;
    private final double size;

    public Positionable(double x, double y, double size){

        this.x = x;
        this.y = y;
        this.size = size;

    }

    //----------Methods----------

    //----------Getters----------

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getSize(){
        return this.size;
    }

    //----------Setters----------

    protected void setX(double x){
        this.x = x;
    }

    protected void setY(double y){
        this.y = y;
    }

}
