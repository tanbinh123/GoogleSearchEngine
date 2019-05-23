package GoogleSearchEngine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This heap class with url, is to help main function to implement
 * the HeapSort Algorithm to sort the web url
 */
public class heap {

    private int heapSize;

    public heap(ArrayList<url> A) {
        heapSize = A.size();
    }

    public void maxHeapify(ArrayList<url> A, int i) {

        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heapSize && A.get(l).getPageRank() > A.get(i).getPageRank()) {
            largest = l;
        }else{
            largest = i;
        }

        if (r < heapSize && A.get(r).getPageRank() > A.get(largest).getPageRank()) {
            largest = r;
        }
        if (largest != i) {
            Collections.swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }

    public void buildMaxHeap(ArrayList<url> A) {

        this.heapSize = A.size();
        for (int i = (A.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    public void HeapSort(ArrayList<url> A) {
        buildMaxHeap(A);
        for (int i = A.size() - 1; i > 0; i--) {
            Collections.swap(A, i, 0);
            heapSize--;
            maxHeapify(A, 0);
        }
    }

    public url HeapExtractMax(ArrayList<url> A) {
        if (heapSize < 1) {
            throw new RuntimeException("heap underflow");
        }
        url max = heapMaximum(A);
        A.set(0, A.get(heapSize - 1));
        heapSize--;
        maxHeapify(A, 0);
        return max;
    }

    public void heapIncreaseKey(ArrayList<url> A, int i, url key) {
        if (key.getPageRank() < A.get(i).getPageRank()) {
            throw new RuntimeException("new key is smaller than current key");
        }
        A.set(i, key);
        while (i > 0 && A.get(getParent(i)).getPageRank() < A.get(i).getPageRank()) {
            Collections.swap(A, i, getParent(i));
            i = getParent(i);
        }
    }

    public void MaxHeapInsert(ArrayList<url> A, url key) {
        heapSize++;
        A.add(key);
        A.get(heapSize - 1).setPageRank((int) Double.NEGATIVE_INFINITY);
        heapIncreaseKey(A, heapSize, key);//then give the leaf real value
    }

    public url heapMaximum(ArrayList<url> A){
        return A.get(0);
    }

    public  int getParent(int i) {
        return (i - 1 / 2);
    }

}
