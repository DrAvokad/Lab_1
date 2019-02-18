package Vehicles;

import Abstracts.IDirection;
import Abstracts.Movable;
import Machine.Engine;
import Machine.ILargeCarrier;
import Machine.ITransportable;
import Machine.Loadable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ferry implements ILargeCarrier, IBoat  {

    private Movable movable;
    private Engine engine = new Engine(2500);
    private ArrayList<Loadable> files;
    private Vehicle vehicle;
    private boolean isOpen;

    public Ferry(double x, double y, IDirection.Direction direction){

        this.movable = new Movable(x, y, direction);
        this.files = new ArrayList<Loadable>(3);
        Loadable<ITransportable> file1 = new Loadable<>(25, 10, true, new ArrayList<ITransportable>());
        Loadable<ITransportable> file2 = new Loadable<>(25, 10, true, new ArrayList<ITransportable>());
        Loadable<ITransportable> file3 = new Loadable<>(25, 10, true, new ArrayList<ITransportable>());
        files.add(file1);
        files.add(file2);
        files.add(file3);
        this.vehicle = new Vehicle(Color.WHITE, "ナイス　ボート");
        isOpen = false;

    }

    private double speedFactor(){
        return engine.getEnginePower() * (0.002 - (files.get(0).getSize()+files.get(1).getSize()
                +files.get(2).getSize())*0.0001);
    }

    @Override
    public void load(ITransportable cargo, int file) {
        if(file <= 0){
            files.get(0).load(cargo, movable, movable.getX(), movable.getY(), cargo.getX(), cargo.getY());
        }else if (file >= files.size()-1){
            files.get(files.size()-1).load(cargo, movable, movable.getX(), movable.getY(), cargo.getX(), cargo.getY());
        }else {
            files.get(file).load(cargo, movable, movable.getX(), movable.getY(), cargo.getX(), cargo.getY());
        }

    }

    @Override
    public ITransportable unload(int file) {
        if(file <= 0){
            return files.get(0).unload();
        }else if(file >= files.size()-1){
            return files.get(files.size()-1).unload();
        }else{
            return files.get(file).unload();
        }
    }

    @Override
    public void gas(double amount) {
        engine.gas(amount, movable.getCurrentSpeed(), speedFactor());
    }

    @Override
    public void brake(double amount) {
        engine.brake(amount, movable.getCurrentSpeed(), speedFactor());
    }

    @Override
    public void startEngine() {
        if(!isOpen) {
            engine.startEngine();
        }
    }

    @Override
    public void stopEngine() {
        engine.stopEngine();
    }

    @Override
    public void move() {
        movable.move();
    }

    @Override
    public void turnLeft() {
        movable.turnLeft();
    }

    @Override
    public void turnRight() {
        movable.turnRight();
    }

    @Override
    public void transport(Movable newMovable) {

    }

    @Override
    public void exitTransport() {

    }

    public double getX() {
        return movable.getX();
    }

    public double getY() {
        return movable.getY();
    }

    private void open(){
        for (Loadable l : files){
            l.open();
        }
        isOpen = true;
    }

    private void close(){
        for (Loadable l : files){
            l.close();
        }
        isOpen = false;
    }
}
