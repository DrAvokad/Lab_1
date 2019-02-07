package Machine;

public interface ITransport<T extends ITransportable> {

    void load(T cargo);
    T unload();
}
