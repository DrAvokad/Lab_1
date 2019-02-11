package Abstracts;

public class Movable implements IDirection {

    private Positionable position;
    private Direction direction;
    private double currentSpeed;

    public Movable(double x, double y, Direction direction) {

        this.position = new Positionable(x, y);
        this.direction = direction;

    }

    //----------Methods----------

    //----------Getters----------

    public double getCurrentSpeed(){
        return this.currentSpeed;
    }

    //----------Setters----------

    public void setCurrentSpeed(double speed){
        this.currentSpeed = speed;
    }

    //----------Moving----------

    public void move() {
        if(direction == Direction.NORTH){
            position.setY(position.getY() - currentSpeed);
        }else if(direction == Direction.SOUTH){
            position.setY(position.getY() + currentSpeed);
        }else if (direction == Direction.EAST){
            position.setX(position.getX() + currentSpeed);
        }else if (direction == Direction.WEST){
            position.setX(position.getX() - currentSpeed);
        }
    }

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
}