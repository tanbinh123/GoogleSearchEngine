package sortingSSN;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;

/**
 * A Junit Test class for testing RadixSort function
 */
public class radixTest {
    /* Testing if get the maximum of an integer arrayList */
    @Test
    public void getMaximum() {
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
        radix r = new radix();
        int [] arr = r.convertToArr(intarr);
        int max = r.getMax(arr, 10);
        assertTrue(max == 905447327);
    }

    /* Testing radixSort method if sorting the integer array[] */
    @Test
    public void radixSort() {
        int [] intarr = new int [10];
        intarr[0] = 100062271;
        intarr[1] = 105437621;
        intarr[2] = 405443621;
        intarr[3] = 535547631;
        intarr[4] = 605647321;
        intarr[5] = 705437627;
        intarr[6] = 205437627;
        intarr[7] = 305443627;
        intarr[8] = 905447327;
        intarr[9] = 805447627;
        radix r = new radix();
        r.radixsort(intarr, 10);
        assertTrue(100062271 == intarr[0]);
        assertTrue(905447327 == intarr[9]);
        for(int i=0; i<intarr.length; i++){
            System.out.println(intarr[i]);
        }
    }

    /* Testing if writing all ssn numbers into the Junit.txt after calling radixSort() */
    @Test
    public void radixSortToFile() throws FileNotFoundException {
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
        radix rx = new radix();
        int [] iarr = rx.convertToArr(templist);
        rx.radixsort(iarr, iarr.length);
        for(int i=0; i<iarr.length; i++){
            out.println(iarr[i]);
        }
        in.close();
        out.close();
    }
}