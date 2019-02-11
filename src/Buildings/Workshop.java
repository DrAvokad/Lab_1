package Buildings;

import Abstracts.Positionable;
import Machine.ICarCarrier;
import Machine.ITransportable;
import Machine.Loadable;
import Vehicles.ICar;

import java.util.ArrayList;

public class Workshop<T extends ICar> implements IBuilding {

    private Positionable position;
    private Loadable<T> workarea;
    private String name;

    public Workshop (double x, double y, int capacity, ArrayList type, String name){

        this.position = new Positionable(x, y);
        this.workarea = new Loadable(capacity, 10, true, type);
        this.name = name;
    }

    public void load(T cargo) {
        workarea.load(cargo, position.getX(), position.getY());
    }

    public T unload() {
        return workarea.unload();
    }

    public void openWorkshop(){
        workarea.open();
    }

    public void closeWorkshop(){
        workarea.close();
    }
}