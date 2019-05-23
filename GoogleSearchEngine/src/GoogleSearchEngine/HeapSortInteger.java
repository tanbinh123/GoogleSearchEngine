package GoogleSearchEngine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class HeapSortInteger for testing 7 methods:
 * 1. maxHeapify
 * 2. buildMaxHeap
 * 3. HeapSort
 * 4. HeapExtractMax
 * 5. heapIncreaseKey
 * 6. MaxHeapInsert
 * 7. heapMaximum
 */
public class HeapSortInteger {

    private int heapSize;

    public HeapSortInteger(ArrayList<Integer> A) {
        heapSize = A.size();
    }

    public void maxHeapify(ArrayList<Integer> A, int i) {

        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heapSize && A.get(l) > A.get(i)) {
            largest = l;
        }else{
            largest = i;
        }

        if (r < heapSize && A.get(r) > A.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            Collections.swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }

    public void buildMaxHeap(ArrayList<Integer> A) {

        this.heapSize = A.size();
        for (int i = (A.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    public void HeapSort(ArrayList<Integer> A) {
        buildMaxHeap(A);
        for (int i = A.size() - 1; i > 0; i--) {
            Collections.swap(A, i, 0);
            heapSize--;
            maxHeapify(A, 0);
        }
    }

    public Integer HeapExtractMax(ArrayList<Integer> A) {
        if (heapSize < 1) {
            throw new RuntimeException("heap underflow");
        }
        Integer max = heapMaximum(A);
        A.set(0, A.get(heapSize - 1));
        heapSize--;
        maxHeapify(A, 0);
        return max;
    }

    public void heapIncreaseKey(ArrayList<Integer> A, int i, Integer key) {
        i--;
        if (key < A.get(i)) {
            throw new RuntimeException("new key is smaller than current key");
        }
        A.set(i, key);
        while (i > 0 && A.get(getParent(i)) < A.get(i)) {
            Collections.swap(A, i, getParent(i));
            i = getParent(i);
        }
    }

    public void MaxHeapInsert(ArrayList<Integer> A, Integer key) {
        heapSize++;
        A.add(key);
        A.set(heapSize-1, (int)Double.NEGATIVE_INFINITY);
        heapIncreaseKey(A, heapSize, key);//then give the leaf real value
    }

    public Integer heapMaximum(ArrayList<Integer> A){
        return A.get(0);
    }

    public  int getParent(int i) {
        return (i - 1 / 2);
    }
}

















