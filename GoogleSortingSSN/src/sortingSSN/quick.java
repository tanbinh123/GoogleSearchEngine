package sortingSSN;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class named quick will sort a required arrayList by
 *  calling quickSort
 */
public class quick {

    //Create a new arrayList in order to add ssn numbers
    private ArrayList<Integer> arrlist;


    /**
     * The following procedure implements quickSort
     * @param arr the given arrayList
     * @param p the left position
     * @param r the right position
     */
    public void quickSort(ArrayList<Integer>arr, int p, int r){
        if(p < r){
            int q = Partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    /**
     * The helper method to help quickSort to find the pivot
     * @param arr the arrayList will be sorting
     * @param p the left position
     * @param r the right position
     * @return the pivot
     */
    public int Partition(ArrayList<Integer>arr, int p, int r){
        int x = arr.get(r);
        int i = p - 1;
        for(int j=p; j<= r-1; j++){
            if(arr.get(j) <= x){
                i = i + 1;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i+1, r);
        return i + 1;
    }
}
