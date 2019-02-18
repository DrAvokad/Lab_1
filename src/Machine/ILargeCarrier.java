package Machine;

public interface ILargeCarrier<T extends ITransportable> {

    void load(T cargo, int file);
    T unload(int file);

}
