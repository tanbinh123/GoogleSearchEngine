package sortingSSN;

import java.util.ArrayList;
/**
 * A bucket class with bucketSort method for sorting a ArrayList
 */
public class bucket{
    /**
     * Convert a Integer arrayList to a double array[]
     * @param intarr the given arrayList with Integer elements
     * @return a double array[]
     */
    public double[] convertArr(ArrayList<Integer> intarr){
        double [] darr = new double[intarr.size()];
        for(int i=0; i<intarr.size(); i++){
            darr[i] =  (intarr.get(i))/ 1000000000.0;
        }
        return darr;
    }

    /**
     * BuckSort method to sort a double array
     * @param arr the required arrayList will order by calling bucketSort()
     * @return the new ArrayList with calling buckSort()
     */
    public void buckSort(double[] arr){

        int n = arr.length;

        /**
         * Create a bucketList with every bucket contains an ArrayList, which
         * double-number element inside it.
         */
        ArrayList<Double>[] bucketList = new ArrayList[n];

        /**
         * make bucketList[i] to be an empty ArrayList
         */
        for(int i=0; i<n; i++){
            bucketList[i] = new ArrayList<Double>();
        }

        /**
         * insert every double element into the appropriate index of bucketList
         */
        for(int i=0; i<n; i++){
            int bucketIndex = (int)(arr[i] * n);
            bucketList[bucketIndex].add(arr[i]);
        }

        /**
         * calling the insertSort to sort every arrayList
         */
        for(int i=0; i<n; i++){
            insertSort(bucketList[i]);
        }

        /* concatenate all buckets */
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<bucketList[i].size(); j++){
                arr[index++] = bucketList[i].get(j);
            }
        }

    }

    /**
     * helper method insertSort to help buckSort to sort a new ArrayList
     * @param arr the arrayList of a bucketList
     */
    public void insertSort(ArrayList<Double> arr){
        for(int j=0; j<arr.size(); j++){
            double key = arr.get(j);
            int i = j-1;
            while(i>0 && arr.get(i)>key){
                arr.set(i+1 , arr.get(i));
                i = i - 1;
            }
            arr.set(i+1, key);
        }
    }

}
