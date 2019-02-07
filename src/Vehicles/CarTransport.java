package Vehicles;

import Machine.ITransport;
import Machine.ITransportable;

import java.awt.*;

public class CarTransport extends Vehicle implements ITransportable, ITransport {

    public CarTransport(double x, double y, double size, Direction direction, Color color, String modelName) {
        super(x, y, size, direction, color, modelName);
    }

    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    public void load(ITransportable car) {

    }

    @Override
    public ITransportable unload() {
        return null;
    }
}
