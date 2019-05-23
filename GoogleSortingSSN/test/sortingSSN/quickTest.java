package sortingSSN;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static org.junit.Assert.*;

/**
 * A Junit Test class for testing QuickSort function
 */
public class quickTest {
    /* Testing if quickSort method to help an arrayList sort its all elements */
    @Test
    public void quickSort() {
        ArrayList<Integer> intarr = new ArrayList<>();
        intarr.add(100062271);
        intarr.add(105437621);
        intarr.add(405443621);
        intarr.add(535547631);
        intarr.add(605647321);
        intarr.add(705437627);
        intarr.add(205437627);
        intarr.add(305443627);
        intarr.add(905447327);
        intarr.add(805447627);
        System.out.println("Original ArrayList: "+ intarr);
        ArrayList<Integer> temp = new ArrayList<>(intarr);
        Collections.sort(temp);
        quick q = new quick();
        q.quickSort(intarr, 0, 9);
        for(int i=0; i<intarr.size(); i++){
            System.out.println(intarr.get(i));
        }
        int min = intarr.get(0);
        int max = intarr.get(intarr.size()-1);

        assertEquals(10, intarr.size());
        assertEquals(100062271, min);
        assertEquals(905447327, max);
        assertEquals(temp, intarr);
        System.out.println();
    }

    /* Testing if return the correct pivot after calling partition() method */
    @Test
    public void partition() {
        ArrayList<Integer> intarr = new ArrayList<>();
        intarr.add(100062271);
        intarr.add(105437621);
        intarr.add(405443621);
        intarr.add(535547631);
        intarr.add(805447627);
        intarr.add(705437627);
        intarr.add(205437627);
        intarr.add(305443627);
        intarr.add(905447327);
        intarr.add(605647321);
        System.out.println("Original ArrayList: "+ intarr);
        quick q = new quick();
        int pivot = q.Partition(intarr, 0, 9);

        assertEquals(6, pivot);

        System.out.println("position: " +pivot+ " element: "+intarr.get(pivot));
        System.out.println();
    }

    /* Testing if writing all ssn numbers into the Junit.txt by calling quickSort method */
    @Test
    public void quickSortToFile() throws FileNotFoundException {
        ArrayList<Integer> templist = new ArrayList<>();
        String inFileName = "transfer.txt";
        File inputFile = new File(inFileName);
        Scanner in = new Scanner(inputFile);
        String outFileName = "Junit.txt";
        PrintWriter out = new PrintWriter(outFileName);
        while(in.hasNextInt()){
            int tempTotalNum = in.nextInt();
            templist.add(tempTotalNum);
        }
        quick q = new quick();
        q.quickSort(templist, 0, (templist.size()-1));
        for(Integer i : templist){
            out.println(i);
        }
        in.close();
        out.close();
    }
}