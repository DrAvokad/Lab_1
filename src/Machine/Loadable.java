package Machine;

import java.util.ArrayList;
import java.util.List;

public class Loadable<T extends ITransportable>{

    private double sizeCap;
    private final int slots;
    private ArrayList<T> load;
    private boolean isOpen;

    public Loadable (double sizeCap, int slots){

        this.sizeCap = sizeCap;
        this.slots = slots;
        this.load = new ArrayList(slots);
        this.isOpen = false;

    }

    //----------Methods----------

    //----------Getters----------

    public double getSizeCap(){
        return this.sizeCap;
    }

    public double getSlots(){
        return this.slots;
    }

    //----------Loadable----------

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }

    public void load(T cargo, double size){
        if(!isFull() && size < sizeCap && isOpen){
            load.add(cargo);
        }
    }

    public ITransportable unload(int index) {
        ITransportable cargo = null;
        if (!load.isEmpty() && isOpen) {
            cargo = load.get(index);
            load.remove(index);
        }
        return cargo;
    }

    //----------Helper Methods----------

    private boolean isFull(){
        return load.size()==slots;
    }
}
