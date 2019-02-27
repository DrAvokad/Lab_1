package Vehicles;

import Abstracts.IDirection;

public class CarFactory {

    public static ICar createSaab95(double x, double y, IDirection.Direction d){ return new Saab95(x, y, d);}
    public static ICar createVolvo240(double x, double y, IDirection.Direction d){ return new Volvo240(x, y, d);}
}
