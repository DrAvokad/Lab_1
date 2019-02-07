package Vehicles;

import Abstracts.Movable;
import Machine.Engine;

import java.awt.*;

public abstract class Vehicle extends Movable {

    private final String modelName;
    private Color color;

    public Vehicle(double x, double y, double size, Direction direction, Color color, String modelName) {
        super(x, y, size, direction);

        this.color = color;
        this.modelName = modelName;

    }

    //----------Methods----------

    abstract double speedFactor();

    //----------Getters----------

    public Color getColor() {
        return color;
    }
}
