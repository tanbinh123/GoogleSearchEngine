package sortingSSN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that it can extract all SSN number from .txt file; all data can display on User Interface
 *  or all data can display on all .txt file
 */
public class extractSSN {
    /* Area name */
    private String necs = "[Northeast Coast States] : ";
    private String scs = "[South Coast States] :  ";
    private String ms = "[Middle States] :  ";
    private String nwcs = "[Northwest Coast States] : ";
    private String wcs = "[West Coast States]  :  ";
    /* Area people number */
    public static int necsPeople;
    public static int scsPeople;
    public static int msPeople;
    public static int nwcsPeople;
    public static int wcsPeople;
    /* after quickSort, bucketSort, and radixSort, all sorted data will into the required ArrayList */
    private ArrayList<String> strlist = new ArrayList<>();
    private ArrayList<String> quickList = new ArrayList<>();
    private ArrayList<String> bucketList = new ArrayList<>();
    private ArrayList<String> radixList = new ArrayList<>();

    /* Access Method: get different area people's number */
    public int getNecsPeople(){
        return necsPeople;
    }
    public int getScsPeople(){
        return scsPeople;
    }
    public int getMsPeople(){
        return msPeople;
    }
    public int getNwcsPeople(){
        return nwcsPeople;
    }
    public int getWcsPeople(){
        return wcsPeople;
    }

    /**
     * A method can help compare first 3 digits, then create a new arrayList
     * @return A new arrayList with the format : " xxx-xx-xxxx "
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<String> generateToRandom_SSN() throws FileNotFoundException{
        ssnCrawler sc = new ssnCrawler();
        sc.generate();

        String inFileName = "transfer.txt";
        File inputFile = new File(inFileName);
        Scanner in = new Scanner(inputFile);
        String outFileName = "Random_SSN.txt";
        PrintWriter out = new PrintWriter(outFileName);
        /**
         *  read every line data, then make the data in this format: " xxx-xx-xxxx ";
         */
        while(in.hasNextInt()){
            String strValue;
            String str = in.nextLine();
            String first = str.substring(0, 3);
            int temp = Integer.parseInt(first);
            if(temp <= 199){ //store every ssn number with the area name
                strValue = necs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >199 && temp <= 399){
                strValue = scs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >399 && temp <= 599){
                strValue = ms + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >599 && temp <= 799){
                strValue = nwcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else{
                strValue = wcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }

            //write every ssn number into the Random_SSN.txt file
            out.println(str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5));
            strlist.add(strValue); //call the arrayList to add every ssn number with the area name
        }
        System.out.println("Written successfully");
        in.close();
        out.close();
        return strlist;
    }

    /**
     * A method using quickSort, then write all data into a .txt file
     * @return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the required .txt file.
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<Integer> quickSortToFile() throws FileNotFoundException{
        /* initialize every area people's numbers */
        ArrayList<Integer> templist = new ArrayList<>();

        String inFileName = "transfer.txt";
        File inputFile = new File(inFileName);
        Scanner in = new Scanner(inputFile);
        String outFileName = "Quick_SSN.txt";
        PrintWriter out = new PrintWriter(outFileName);

        while(in.hasNextInt()){
            int tempTotalNum = in.nextInt();
            templist.add(tempTotalNum);
        }

        /**
         * Now create a new quick object, then calling the quickSort to sort the required arrayList
         */
        quick ql = new quick();
        ql.quickSort(templist, 0,templist.size()-1);

        //write every ssn number into the Quick_SSN.txt file
        for(int i=0; i<templist.size(); i++){
            String str = "";
            str = str + templist.get(i);
            out.println(str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5));
        }
        System.out.println("Written successfully");
        in.close();
        out.close();
        return templist;
    }

    /**
     * A method using quickSort, then display all data on the User Interface
     * @return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the User Interface.
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<String> quickSortToUI() throws FileNotFoundException{
        ArrayList<Integer> tempUI = quickSortToFile();
        necsPeople = 0;
        scsPeople = 0;
        msPeople = 0;
        nwcsPeople = 0;
        wcsPeople = 0;

        String strValue;
        for(int i=0; i<tempUI.size(); i++){
            String str = "";
            str = str + tempUI.get(i);
            String first = str.substring(0, 3);
            int temp = Integer.parseInt(first);
            if(temp <= 199){ //store every ssn number with the area name
                necsPeople++;
                strValue = necs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >199 && temp <= 399){
                scsPeople++;
                strValue = scs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >399 && temp <= 599){
                msPeople++;
                strValue = ms + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >599 && temp <= 799){
                nwcsPeople++;
                strValue = nwcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else{
                wcsPeople++;
                strValue = wcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }
            quickList.add(strValue); //call the arrayList quickList to add every ssn number with the area name
        }
        return quickList;
    }

    /**
     *  A method using bucketSort, then write all data into a .txt file
     * @return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the required .txt file.
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<Integer> bucketSortToFile() throws FileNotFoundException{
        /* initialize every area people's numbers */
        ArrayList<Integer> templist = new ArrayList<>();
        ArrayList<Integer> afterBucketSort = new ArrayList<>();

        String inFileName = "transfer.txt";
        File inputFile = new File(inFileName);
        Scanner in = new Scanner(inputFile);
        String outFileName = "Bucket_SSN.txt";
        PrintWriter out = new PrintWriter(outFileName);

        while(in.hasNextInt()){
            int tempTotalNum = in.nextInt();
            templist.add(tempTotalNum);
        }

        bucket bt = new bucket();
        double [] darr = bt.convertArr(templist);  //covert an Integer arrayList to a double array[]
        bt.buckSort(darr); //call bucketSort method to sort the double array[]
        for(double d : darr){
            int temp =(int) (d * 1000000000);
            afterBucketSort.add(temp);
        } //After called bucketSort method, convert double array[] to Integer arrayList

        //write every ssn number into the Bucket_SSN.txt file
        for(int i=0; i<afterBucketSort.size(); i++){
            String str = "";
            str = str + afterBucketSort.get(i);
            out.println(str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5));
        }
        System.out.println("Written successfully");
        in.close();
        out.close();
        return afterBucketSort;
    }

    /**
     *A method using bucketSort, then display all data on the User Interface
     *@return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the User Interface.
     *@throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<String> bucketSortToUI() throws FileNotFoundException{
        ArrayList<Integer> tempUI = bucketSortToFile();
        necsPeople = 0;
        scsPeople = 0;
        msPeople = 0;
        nwcsPeople = 0;
        wcsPeople = 0;

        String strValue;
        for(int i=0; i<tempUI.size(); i++){
            String str = "";
            str = str + tempUI.get(i);
            String first = str.substring(0, 3);
            int temp = Integer.parseInt(first);
            if(temp <= 199){ //store every ssn number with the area name
                necsPeople++;
                strValue = necs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >199 && temp <= 399){
                scsPeople++;
                strValue = scs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >399 && temp <= 599){
                msPeople++;
                strValue = ms + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >599 && temp <= 799){
                nwcsPeople++;
                strValue = nwcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else{
                wcsPeople++;
                strValue = wcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }
            bucketList.add(strValue);   //call the arrayList bucketList to add every ssn number with the area name
        }
        return bucketList;
    }

    /**
     * A method using radixSort, then write all data into a .txt file
     * @return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the required .txt file.
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<Integer> radixSortToFile() throws FileNotFoundException{
        /* initialize every area people's numbers */
        ArrayList<Integer> templist = new ArrayList<>();
        ArrayList<Integer> afterRadixSort = new ArrayList<>();

        String inFileName = "transfer.txt";
        File inputFile = new File(inFileName);
        Scanner in = new Scanner(inputFile);
        String outFileName = "Radix_SSN.txt";
        PrintWriter out = new PrintWriter(outFileName);

        while(in.hasNextInt()){
            int tempTotalNum = in.nextInt();
            templist.add(tempTotalNum);
        }

        /**
         * Now create a new radix object, then calling the quickSort to sort the required arrayList
         */
        radix rx = new radix();
        int [] iarr = rx.convertToArr(templist); //convert the arrayList to a temporary array[]
        rx.radixsort(iarr, templist.size()); // call radixSort to sort the temporary array
        for(int i : iarr){
            afterRadixSort.add(i);
        }  //call the an arrayList afterRadixSort to add temporary array's integer element

        //write every ssn number into the Radix_SSN.txt file
        for(int i=0; i<afterRadixSort.size(); i++){
            String str = "";
            str = str + afterRadixSort.get(i);
            out.println(str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5));
        }

        System.out.println("Written successfully");
        in.close();
        out.close();
        return afterRadixSort;
    }

    /**
     *A method using radixSort, then display all data on the User Interface
     *@return A arrayList with this format " xxx-xx-xxxx "; then it will write all data into the User Interface.
     *@throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public ArrayList<String> radixSortToUI() throws FileNotFoundException{
        ArrayList<Integer> tempUI = radixSortToFile();
        necsPeople = 0;
        scsPeople = 0;
        msPeople = 0;
        nwcsPeople = 0;
        wcsPeople = 0;

        String strValue;
        for(int i=0; i<tempUI.size(); i++){
            String str = "";
            str = str + tempUI.get(i);
            String first = str.substring(0, 3);
            int temp = Integer.parseInt(first);
            if(temp <= 199){  //store every ssn number with the area name
                necsPeople++;
                strValue = necs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >199 && temp <= 399){
                scsPeople++;
                strValue = scs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >399 && temp <= 599){
                msPeople++;
                strValue = ms + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else if(temp >599 && temp <= 799){
                nwcsPeople++;
                strValue = nwcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }else{
                wcsPeople++;
                strValue = wcs + str.substring(0, 3) + "-" + str.substring(3,5)+ "-" + str.substring(5);
            }
            radixList.add(strValue);  //call the arrayList radixList to add every ssn number with the area name
        }
        return radixList;
    }
    

}
