import java.util.ArrayList;
import java.util.List;

public class Sort {
    static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) { // if arr[j] > arr[j+1] return 1
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static <T extends Comparable <T>> void mergeSort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr,l,m,r);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
        int size1 = m - l + 1;
        int size2 = r - m;

//        T[] arr1 = (T[]) new Object[size1];
//        T[] arr2 = (T[]) new Object[size2];

        List<T> arr1 = new ArrayList<T>();
        List<T> arr2 = new ArrayList<T>();

        for (int i = 0; i < size1; i++) {
            arr1.add(i, arr[l + i]);
        }
        for (int i = 0; i < size2; i++) {
            arr2.add(i, arr[m + 1 + i]);
        }

        int i = 0, j = 0, k = l;

        while(i < size1 && j < size2) {
            if(arr1.get(i).compareTo(arr2.get(j)) < 0) {
                arr[k] = arr1.get(i);
                i++;
            }
            else{
                arr[k] = arr2.get(j);
                j++;
            }
            k++;
        }

        while(i < size1) {
            arr[k] = arr1.get(i);
            i++;
            k++;
        }

        while(j < size2) {
            arr[k] = arr2.get(j);
            j++;
            k++;
        }
    }

}
