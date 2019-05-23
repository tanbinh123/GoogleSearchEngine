package sortingSSN;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A radix class by calling radix sort to sort a new arrayList
 */
public class radix {

    /**
     * @param arr the required arrayList to convert to a integer array
     * @return a new integer array
     */
    public int[] convertToArr(ArrayList<Integer> arr){
        int [] iarr = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            iarr[i] =  arr.get(i);
        }
        return iarr;
    }
    /**
     * Get the maximum from this array
     * @param arr the required array will be sorted
     * @param n the length of this array
     * @return a maximum
     */
    public int getMax(int arr[], int n){
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * The helper method to help radixSort to sort the SSN number
     * @param arr the required array
     * @param n the array's lenght
     * @param places the every digit place
     */
    public void countSort(int arr[], int n, int places){
        int B[]  = new int[n];
        int count[] = new int[10];
        /* initialize every element to be 0 */
        Arrays.fill(count,0);

        /* count every digit from 0-9 that the number of times of appearance */
        for(int i=0; i<n; i++){
            count[ (arr[i]/places)%10]++;
        }

        //updated the array C[]
        for(int j=1; j<10; j++){
            count[j] =  count[j] + count[j-1];
        }

        //input the sorted number into the appropriate index
        for(int j=n-1; j>=0; j--){
            B[count[(arr[j]/places)%10]-1] = arr[j];
            count[ (arr[j]/places)%10 ]--;
        }

        //copy the new array to the original array
        for(int i=0; i<n; i++){
            arr[i] = B[i];
        }
    }

    /**
     * The radixSort method to sort SSN numbers
     * @param arr the required array
     * @param n the array's length
     */
    public void radixsort(int arr[], int n){
        int max = getMax(arr, n);

        //for every place, call countSort to help sort the number from 0-9
        for(int places=1; max/places > 0; places *= 10){
            countSort(arr, n, places);
        }
    }

}
