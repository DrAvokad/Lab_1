package Vehicles;

import Abstracts.Movable;
import Machine.ITransportable;

public interface ICar extends ITransportable, IMotorvehicles {

    int getNrDoors();

}
