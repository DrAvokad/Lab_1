import Abstracts.IDirection;
import Vehicles.CarFactory;
import Vehicles.ICar;
import Vehicles.Saab95;
import Vehicles.Scania;

import javax.swing.*;

public class BouncyCars {

    public static void main(String[] args) {
        // Instance of this class
        CarModel carModel = new CarModel();

        carModel.cars.add(CarFactory.createVolvo240(0,0, IDirection.Direction.SOUTH));
        ICar saab = CarFactory.createSaab95(200, 0, IDirection.Direction.SOUTH);
        carModel.cars.add(saab);
        Scania scania = new Scania(400,0, IDirection.Direction.SOUTH);
        carModel.cars.add(scania);

        //DrawPanel view = new DrawPanel(carModel, 800, 560);
        CarController cc = new CarController(carModel, new CarView("SuperController5000"));
        DrawView cv = new DrawView(carModel, "Gräsmattan", 800, 560 );

        /*JFrame fram3 = new JFrame();
        fram3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fram3.add(view);
        fram3.pack();
        fram3.setVisible(true);
*/

        carModel.addObserver(cv);
        // Start the timer
        carModel.timer.start();
    }
}
