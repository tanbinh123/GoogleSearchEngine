package GoogleSearchEngine;

import java.util.ArrayList;

/**
 * A debug calss for debugging the heap calss
 */
public class debugHeap {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(33);
        a.add(44);
        a.add(111);
        a.add(222);
        a.add(33);
        a.add(19);
        a.add(55);
        a.add(132);
        HeapSortInteger testHeap = new HeapSortInteger(a);
//        System.out.println("Original heap print:");
//        System.out.println(a);
//        testHeap.buildMaxHeap(a);
//        System.out.println("Test build-max-heap");
//        System.out.println("Expected build-max-heap: [222, 132, 33, 55, 111, 10, 33, 19, 44, 20]");
//        System.out.println(a);

//        System.out.println("Original heap list is: [222, 132, 33, 55, 111, 10, 33, 19, 44, 20]");
//        System.out.println("Expected heap-sort: [10, 19, 20, 33, 33, 44, 55, 111, 132, 222]");
//        testHeap.HeapSort(a);
//        System.out.println(a);

//          testHeap.buildMaxHeap(a);
//          System.out.println("Expected heap-Maximum: 222");
//          System.out.println("Current Heap-Maximum: "+testHeap.heapMaximum(a));

        testHeap.buildMaxHeap(a);
        System.out.println("Original heap list is: " + a);

        System.out.println("Expected heap list is: [222, 132, 33, 55, 111, 10, 33, 19, 44, 20, 67]");
        testHeap.MaxHeapInsert(a, 67);
        System.out.println("Current Heap list is: "+a);

        Integer temp = testHeap.HeapExtractMax(a);
        System.out.println("Expected heap list is: [222]");
        System.out.println(temp);

    }

}
