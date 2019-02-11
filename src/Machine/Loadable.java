package Machine;

import Abstracts.Movable;
import Vehicles.ICar;

import java.util.ArrayList;
import java.util.List;

public class Loadable<T extends ITransportable>{

    private final int slots;
    private double range;
    private ArrayList<T> load;
    private boolean isOpen;
    private boolean fiFo;

    public Loadable (int slots, double range, boolean fiFo, ArrayList<T> type){

        this.slots = slots;
        this.range = range;
        this.load = type;
        this.isOpen = false;
        this.fiFo = fiFo;

    }

    //----------Methods----------

    //----------Getters----------

    public double getSlots(){
        return this.slots;
    }

    public int getCurrentLoad() { return load.size(); }

    public boolean isOpen(){
        return isOpen;
    }

    public T getCargo(int i){
        return load.get(i);
    }

    public int getSize(){
        return load.size();
    }

    //----------Setters----------

    public void setFiFo(boolean ToF){
        this.fiFo = ToF;
    }

    //----------Loadable----------

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }

    public void load(T cargo, Movable movable, double x, double y, double x2, double y2){
        if(!isFull() && isOpen && inRange(x, y, x2, y2)){
            cargo.transport(movable);
            load.add(cargo);
        }
    }

    public void load(T cargo, double x, double y, double x2, double y2){
        if(!isFull() && isOpen && inRange(x, y, x2, y2)){
            load.add(cargo);
        }
    }

    public T unload() {
        T cargo = null;
        if (!load.isEmpty() && isOpen && fiFo) {
            cargo = load.get(0);
            load.remove(0);
        }else if(!load.isEmpty() && isOpen && !fiFo){
            cargo = load.get(load.size()-1);
            load.remove(load.size()-1);
        }
        cargo.exitTransport();
        return cargo;
    }

    //----------Helper Methods----------

    private boolean isFull(){
        return load.size()==slots;
    }

    private boolean inRange(double x, double y, double x2, double y2){
        return (x2 <= x+range && y2 <= y+range);
    }

    private void transport(ITransportable cargo, Movable movable){
        cargo.transport(movable);
    }


}
