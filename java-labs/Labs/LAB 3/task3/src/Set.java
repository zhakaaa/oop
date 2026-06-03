import java.util.ArrayList;
import java.util.List;

public class Set<T extends Comparable<T>> implements IUniqueCollection<T>, IOrderedCollection<T>{
    private List<T> list;
    public Set(){
        list = new ArrayList<T>();
    }

    @Override
    public void print() {
        sort(list);
        for(T i : list){
            System.out.print(i + " ");
        }
    }


    @Override
    public void add(T o) {
        if(isUnique(o)){
            list.add(o);
        }
    }

    @Override
    public void remove(T o) {
        for(T i : list){
            if(i == o){
                list.remove(i);
                break;
            }
        }
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public boolean isUnique(T o) {
        if(list.contains(o)){
            return false;
        }
        return true;
    }


    private static <T> void swap(List<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));    // Set the element at index i to the element at index j
        arr.set(j, temp);
    }

    @Override public void sort(List<T> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) { // if arr[j] > arr[j+1] return 1
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
