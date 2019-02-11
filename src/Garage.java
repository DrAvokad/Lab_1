import java.util.ArrayList;

public class Garage<E> {
    protected ArrayList<E> cars;
    private int roomCapacity;

    public Garage(int roomCapacity, ArrayList<E> cars){
        this.roomCapacity = roomCapacity;
        this.cars = cars;
    }

    public E getCar(int i){
        return cars.get(i);
    }

    public void addCar(E car){
        if (cars.size() < roomCapacity)
        cars.add(car);
    }

    public void removeCar(E car){
        cars.remove(car);
    }

}
