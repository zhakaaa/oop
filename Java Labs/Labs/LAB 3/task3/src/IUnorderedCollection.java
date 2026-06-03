public interface IUnorderedCollection<T> extends IMyCollection<T> {
    T top();
    T pop();
}
