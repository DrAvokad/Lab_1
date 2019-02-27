import Abstracts.IDirection;
import Vehicles.CarFactory;
import Vehicles.ICar;
import Vehicles.Saab95;
import Vehicles.Scania;

public class BouncyCars {

    public static void main(String[] args) {
        // Instance of this class
        CarView frame = new CarView("CarSim 1.0");
        CarController cc = new CarController(frame);

        cc.cars.add(CarFactory.createVolvo240(0,0, IDirection.Direction.SOUTH));
        ICar saab = CarFactory.createSaab95(200, 0, IDirection.Direction.SOUTH);
        cc.cars.add(saab);
        cc.turbos.add((Saab95)saab);
        Scania scania = new Scania(400,0, IDirection.Direction.SOUTH);
        cc.cars.add(scania);
        cc.flatbeds.add(scania);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
