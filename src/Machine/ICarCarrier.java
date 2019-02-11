package Machine;

import Vehicles.ICar;

public interface ICarCarrier<T extends ITransportable> {

    void load(ICar cargo);
    ICar unload();
}
