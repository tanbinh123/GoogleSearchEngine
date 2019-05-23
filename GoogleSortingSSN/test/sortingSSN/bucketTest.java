package sortingSSN;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;
/**
 * A Junit Test class for testing BucketSort function
 */
public class bucketTest {
    /* Testing the method that convert the integer arrayList to double array[] */
    @Test
    public void convertToDoubleArray(){
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
        bucket bt = new bucket();
        double[] darr = bt.convertArr(intarr);
        for(double d : darr)
            System.out.println(d);
        System.out.println("*******************");
    }

    /* Testing the bucketSort method to sort the double array[] */
    @Test
    public void buckSort(){
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
        bucket bt = new bucket();
        double[] darr = bt.convertArr(intarr);
        bt.buckSort(darr);
        for(double d : darr)
            System.out.println(d);
        System.out.println("*******************");
        assertTrue(0.100062271 == darr[0]);
        assertTrue(0.905447327 == darr[9]);
    }

    /* Testing if the ssn number writing into the Junit.txt file by correct order */
    @Test
    public void buckSortToFile() throws FileNotFoundException {
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
        bucket bt = new bucket();
        double [] darr = bt.convertArr(templist);
        bt.buckSort(darr);
        for(double d : darr){
            int temp =(int) (d * 1000000000);
            out.println(temp);
        }
        in.close();
        out.close();
    }
}