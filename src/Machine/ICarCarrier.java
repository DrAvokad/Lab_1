package Machine;

import Vehicles.ICar;

public interface ICarCarrier<T extends ITransportable> {

    void load(ITransportableByCarTransport cargo);
    ITransportableByCarTransport unload();
}
