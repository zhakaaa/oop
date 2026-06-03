public interface IDuplicateCollection<T> extends IMyCollection<T> {
    boolean isDuplicate(T obj);
}
