import Machine.IFlatbed;
import Machine.ITurbo;
import Vehicles.CarFactory;
import Vehicles.IMotorvehicles;
import Vehicles.Saab95;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarModel {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    ArrayList<IMotorvehicles> cars = new ArrayList<>();
    ArrayList<ITurbo> turbos = new ArrayList<>();
    ArrayList<IFlatbed> flatbeds = new ArrayList<>();


    //ArrayList<ITruck> trucks = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Point> points = new ArrayList<>();

            for (IMotorvehicles car : cars) {
                car.move();
                int x = (int) Math.round(car/*.getPosition()*/.getX());
                int y = (int) Math.round(car/*.getPosition()*/.getY());
                points.add(new Point(x,y));
                if (car.getY() > 500 || car.getY() < 0){
                    car.turnRight();
                    car.turnRight();

                }
            }
            notifyObservers();
        }
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IMotorvehicles car : cars) {
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
            car.setTurboOn();
        }
    }

    void saabTurboOff(){
        for (ITurbo car : turbos){
            Saab95 saab = (Saab95) car;
            saab.setTurboOff();
        }
    }

    void scaniaTiltUp(){
        for (IFlatbed truck : flatbeds){
            truck.tiltLoadingPlatform(1);
        }
    }

    void scaniaTiltDown(){
        for (IFlatbed truck : flatbeds){
            truck.tiltLoadingPlatform(-1);
        }
    }

    private ArrayList<IActionListner> observers = new ArrayList<>();
    public void addObserver (IActionListner o){ observers.add(o); }

    private void notifyObservers(){
        for(IActionListner o : observers){
            o.actOnUpdate();
        }
    }
}
