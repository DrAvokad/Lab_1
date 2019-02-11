package Machine;

import java.util.ArrayList;
import java.util.List;

public class Loadable<T extends ITransportable>{

    private double sizeCap;
    private final int slots;
    private double range;
    private ArrayList<T> load;
    private boolean isOpen;
    private boolean fiFo;

    public Loadable (double sizeCap, int slots, double range, boolean fiFo){

        this.sizeCap = sizeCap;
        this.slots = slots;
        this.range = range;
        this.load = new ArrayList(slots);
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

    public void load(T cargo, double size, double x, double y){
        if(!isFull() && size < sizeCap && isOpen && inRange(x, y)){
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
        return cargo;
    }

    public void transport (ITransportable cargo, ITransport t){
        cargo.isTransported(t.getX(), t.getY());
    }

    //----------Helper Methods----------

    private boolean isFull(){
        return load.size()==slots;
    }

    private boolean inRange(double x, double y){
        return (Math.abs(x) <= range && Math.abs(y) <= range);
    }


}
