package Abstracts;

public abstract class Movable extends Positionable {

    private Direction direction;
    private double currentSpeed;

    public enum Direction {
        NORTH, SOUTH, WEST, EAST
    }

    public Movable(double x, double y, double size, Direction direction) {
        super(x, y, size);

        this.direction = direction;

    }

    //----------Methods----------

    //----------Getters----------

    public double getCurrentSpeed(){
        return this.currentSpeed;
    }

    //----------Setters----------

    protected void setCurrentSpeed(double speed){
        this.currentSpeed = speed;
    }

    //----------Moving----------

    public void move() {
        if(direction == Direction.NORTH){
            setY(getY() - currentSpeed);
        }else if(direction == Direction.SOUTH){
            setY(getY() + currentSpeed);
        }else if (direction == Direction.EAST){
            setX(getX() + currentSpeed);
        }else if (direction == Direction.WEST){
            setX(getX() - currentSpeed);
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