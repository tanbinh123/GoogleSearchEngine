package sortingSSN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * A class ssnCrawler can generate random 300 SSN number
 */
public class ssnCrawler {

    /**
     * This method to help user generate 300 SSN number
     * @throws FileNotFoundException if the System can not find the .txt file, it will throw out Exception
     */
    public static void generate() throws FileNotFoundException {
        String outFileName = "transfer.txt";
        File outFile = new File(outFileName);
        PrintWriter output = new PrintWriter(outFile);
        /**
         * generating 300 Random SSN numbers
         */
        for(int index=1; index<301; index++){
            int randomSSN = 100000000 + new Random().nextInt(900000000);
            output.println(randomSSN);
        }
        output.close();
        System.out.println("Generate SSN numbers successfully");

    }

    /**
     * Testing the generate() method if it generating successfully
     * @param args
     */
    public static void main(String[] args) {
        try{
            generate();
        }catch (IOException e){

        }
    }
}
