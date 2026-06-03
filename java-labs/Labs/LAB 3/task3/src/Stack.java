import java.util.ArrayList;
import java.util.List;

public class Stack <T extends Comparable<T>> implements IDuplicateCollection<T>, IUnorderedCollection<T> {

    private List<T> list;
    public Stack() {
        list = new ArrayList<T>();
    }

    @Override
    public boolean isDuplicate(T obj) {
        return true;
    }

    @Override
    public void print() {}

    @Override
    public void add(T o) {
        list.add(o);
    }

    @Override
    public void remove(T o) {}

    @Override public T pop() {
        T temp = list.removeLast();
        return temp;
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public T top() {
        int index = list.size() - 1;
        return list.get(index);

    }
}
