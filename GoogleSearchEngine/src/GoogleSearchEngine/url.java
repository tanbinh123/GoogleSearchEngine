package GoogleSearchEngine;

/**
 * A url class simulate the 4 factor:
 * 1. keywordScore
 * 2. existScore
 * 3. linkScore
 * 4. paidScore
 * 5. totalScore = pageRank
 */
public class url {

    private int keywordScore;
    private int existScore;
    private int linkScore;
    private int score4;
    private int paidScore;
    private int pageRank;    //total score

    private int addedRank;
    private String webUrl;
    private int index;

    public url(String s){
        webUrl = s;
        linkScore = (int)(Math.random()* 30);
        keywordScore = (int)(Math.random()* 30);
        existScore = (int)(Math.random()* 30);
        score4 = (int)(Math.random()* 30);;
        paidScore = 0;

    }

    public url(String theUrl, int s1, int s2, int s3, int s4, int s5){
        webUrl = theUrl;
        linkScore = s1;
        keywordScore = s2;
        existScore = s3;
        score4 = s4;
        paidScore = s5;
    }


    /* manipulate method */

    public void setKeywordScore(int ks){
        keywordScore = ks;
    }

    public void setExistScore(int es){
        existScore = es;
    }

    public void setLinkScore(int ls){
        linkScore = ls;
    }

    public void setScore4(int s4){
        score4 = s4;
    }

    public void setPaidScore(int ps){
        paidScore = ps;
    }

    public void setPageRank(int pr){
        pageRank = pr;
    }

    public void setIndex(int i){
        index = i;
    }

    /* Asscess Method*/

    public int getKeywordScore() {
        return keywordScore;
    }

    public int getExistScore(){
        return existScore;
    }

    public int getLinkScore(){
        return linkScore;
    }

    public int getScore4() {return score4;}

    public int getPaidScore(){
        return paidScore;
    }

    public int getIndex(){
        return index;
    }

    public int getPageRank(){
        pageRank = keywordScore + existScore + linkScore + score4 + paidScore;
        return pageRank;
    }

    public String getWebUrl(){
        return webUrl;
    }


}
