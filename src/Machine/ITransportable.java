package Machine;

import Abstracts.Movable;

public interface ITransportable {
    void transport(Movable newMovable);
    void exitTransport();
    double getX();
    double getY();
}
