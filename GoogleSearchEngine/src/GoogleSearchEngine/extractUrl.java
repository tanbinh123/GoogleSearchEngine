package GoogleSearchEngine;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class extractUrl, to get the web URL
 */
public class extractUrl {

    private ArrayList<url> list = new ArrayList<>();


    /**
     *
     * @param keyword the string user inputted, will constructor a new WebCrawler
     * @return a arrayList contains the web url.
     */
    public ArrayList<url> extractWebUrl(String keyword){
        int index = 1;
        WebCrawler c = new WebCrawler(keyword);
        c.search();
        Set<String> set = c.getUrls();

        for(String s : set){
            if(index <= 30){
                int s1 = (int)(Math.random()* 30);
                int s2 = (int)(Math.random()* 30);
                int s3 = (int)(Math.random()* 30);
                int s4 = (int)(Math.random()* 30);
                int s5 = 0;
                s = "https://" + s;

                url weburl = new url(s, s1, s2, s3, s4, s5);
                list.add(weburl);
                index++;
            }
        }
        return list;
    }

//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        ArrayList<url> urlList = new ArrayList<>();
//        System.out.println("Please enter your keyword: ");
//        String keyword = input.next(); //.toLowerCase();
//        WebCrawler c = new WebCrawler(keyword);
//        c.search();
//        Set<String> set = c.getUrls();
//        int index = 1;
//        for(String urlstr : set){
//            System.out.println("["+index+"] " + urlstr);
//            index++;
//        }
//
//
//    }
}
