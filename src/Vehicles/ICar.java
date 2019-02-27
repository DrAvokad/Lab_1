package Vehicles;

import Abstracts.Movable;
import Machine.ITransportable;
import Machine.ITransportableByCarTransport;

public interface ICar extends ITransportable, IMotorvehicles, ITransportableByCarTransport {

    int getNrDoors();

}
