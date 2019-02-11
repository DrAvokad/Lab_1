package Vehicles;

import Abstracts.*;
import Machine.Engine;

import java.awt.*;

public class Vehicle {

    private final String modelName;
    private Color color;

    public Vehicle(Color color, String modelName) {

        this.modelName = modelName;
        this.color = color;

    }

    //----------Methods----------

    //abstract double speedFactor();

    //----------Getters----------

    public Color getColor() {
        return color;
    }

    public String getModelName(){ return  modelName; }
}
