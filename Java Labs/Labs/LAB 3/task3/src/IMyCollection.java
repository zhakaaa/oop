public interface IMyCollection<T> {
    void print();
    void add(T o);
    void remove(T o);
    int length();
}
