import Abstracts.IDirection;
import Machine.ITurbo;
import Vehicles.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController  {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<IMotorvehicles> cars = new ArrayList<>();
    ArrayList<ITurbo> turbos = new ArrayList<>();

    //ArrayList<ITruck> trucks = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0, IDirection.Direction.SOUTH));
        Saab95 saab =new Saab95(200, 0, IDirection.Direction.SOUTH);
        cc.cars.add(saab);
        cc.turbos.add(saab);
        cc.cars.add(new Scania(400,0, IDirection.Direction.SOUTH));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Point> points = new ArrayList<>();
            ArrayList<String> imageList = new ArrayList<>();

            for (IMotorvehicles car : cars) {
                car.move();
                int x = (int) Math.round(car/*.getPosition()*/.getX());
                int y = (int) Math.round(car/*.getPosition()*/.getY());
                points.add(new Point(x,y));
                imageList.add(car.getClass().getSimpleName());
                if (car.getY() > 500 || car.getY() < 0){
                    car.turnRight();
                    car.turnRight();

                }
            }
            frame.drawPanel.moveit(points, imageList);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IMotorvehicles car : cars
        ) {
            car.gas(gas);
        }
    }

    void startEngine(){
        for (IMotorvehicles car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (IMotorvehicles car : cars){
            car.stopEngine();
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (IMotorvehicles car : cars){
            car.brake(brake);
        }
    }

    void saabTurboOn(){
        for (ITurbo car : turbos){
            Saab95 saab = (Saab95) car;
            saab.setTurboOn();
        }
    }

    void saabTurboOff(){
        for (ITurbo car : turbos){
            Saab95 saab = (Saab95) car;
            saab.setTurboOff();
        }
    }




}





