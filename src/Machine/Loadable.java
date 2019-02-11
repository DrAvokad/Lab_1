package Machine;

import Abstracts.Movable;

import java.util.ArrayList;
import java.util.List;

public class Loadable<T extends ITransportable>{

    private double sizeCap;
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

    public double getSizeCap(){
        return this.sizeCap;
    }

    public double getSlots(){
        return this.slots;
    }

    public int getCurrentLoad() { return load.size(); }

    public boolean isOpen(){
        return isOpen;
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

    public void load(T cargo, Movable movable, double x, double y){
        if(!isFull() && isOpen && inRange(x, y)){
            cargo.transport(movable);
            load.add(cargo);
        }
    }

    public void load(T cargo, double x, double y){
        if(!isFull() && isOpen && inRange(x, y)){
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
            load.remove(load.size());
        }
        cargo.exitTransport();
        return cargo;
    }

    //----------Helper Methods----------

    private boolean isFull(){
        return load.size()==slots;
    }

    private boolean inRange(double x, double y){
        return (Math.abs(x) <= range && Math.abs(y) <= range);
    }

    private void transport(ITransportable cargo, Movable movable){
        cargo.transport(movable);
    }


}
