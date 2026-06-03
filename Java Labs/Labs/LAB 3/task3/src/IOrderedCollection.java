import java.util.List;

interface IOrderedCollection <T> extends IMyCollection<T> {
    void sort(List<T> arr);
}
