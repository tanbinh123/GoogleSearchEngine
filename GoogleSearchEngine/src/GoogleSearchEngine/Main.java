package GoogleSearchEngine;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * A Main class to implement all Handling events for the users
 * The goal is to let all users to fell more intuitive than display on console
 */
public class Main extends Application {

    private Button searchBtn1; //decorate the main Google Search Engine interface, is not useful
    private Button searchBtn2; //decorate the main Google Search Engine interface, is not useful
    private Button searchBtn3; //decorate the main Google Search Engine interface, is not useful
    private Button searchBtn4; //decorate the main Google Search Engine interface

    private Button searchBtn;  //the main Google Search Engine Button
    private Button show20webButton;
    private Button insertNewButton;
    private Button getMaxButton;
    private Button pickButton;
    private Button vipButton;
    private static TextField searchText;
    private extractUrl extractWebUrl = new extractUrl();

    private String searchKeyWord;
    private ArrayList<url> urlList;  //define a heaplist to use sort method
    public static int pickIndex = 0;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        searchText = new TextField("input your keyword: ");
        searchText.setPrefHeight(30);

        FileInputStream input = new FileInputStream("home.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        searchBtn = new Button("Google  Search", imageView);
        searchBtn.setPrefWidth(200);

        FileInputStream input1 = new FileInputStream("android.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        searchBtn1 = new Button("Google scholar", imageView1);
        searchBtn1.setPrefWidth(200);

        FileInputStream input2 = new FileInputStream("google.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        searchBtn2 = new Button("Find a Job   ", imageView2);
        searchBtn2.setPrefWidth(200);

        FileInputStream input3 = new FileInputStream("chorme.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        searchBtn3 = new Button("Google Chorme", imageView3);
        searchBtn3.setPrefWidth(200);

        FileInputStream input4 = new FileInputStream("apple.png");
        Image image4 = new Image(input4);
        ImageView imageView4 = new ImageView(image4);
        searchBtn4 = new Button(" iMac        ", imageView4);
        searchBtn4.setPrefWidth(200);

        FileInputStream input5 = new FileInputStream("android.png");
        Image image5 = new Image(input5);
        ImageView imageView5 = new ImageView(image5);
        show20webButton = new Button("Show20 TopLink", imageView5);
        show20webButton.setPrefWidth(200);

        FileInputStream input6 = new FileInputStream("android.png");
        Image image6 = new Image(input6);
        ImageView imageView6 = new ImageView(image6);
        insertNewButton = new Button("insert New url", imageView6);
        insertNewButton.setPrefWidth(200);

        FileInputStream input7 = new FileInputStream("android.png");
        Image image7 = new Image(input7);
        ImageView imageView7 = new ImageView(image7);
        getMaxButton = new Button("extract max PageRank", imageView7);
        getMaxButton.setPrefWidth(200);

        FileInputStream input8 = new FileInputStream("android.png");
        Image image8 = new Image(input8);
        ImageView imageView8 = new ImageView(image8);
        pickButton = new Button("Pick a webUrl", imageView8);
        pickButton.setPrefWidth(200);

        FileInputStream input9 = new FileInputStream("android.png");
        Image image9 = new Image(input9);
        ImageView imageView9 = new ImageView(image9);
        vipButton = new Button("VIP Pay$ AD", imageView9);
        vipButton.setPrefWidth(200);

        /**
         * searchBtn event driven -> search the web usr with keyword
         */
        searchBtn.setOnAction((ActionEvent event)->{
            /*  A ListView displays a horizontal or vertical list of items from which the user may select
                A ListView is able to have its generic type set to represent the type of data in the backing model.
             */
            ListView<String> searchView = new ListView<>();
            searchView.setPrefSize(800, 700);
            int index = 1;
            searchKeyWord = searchText.getText();
            urlList = extractWebUrl.extractWebUrl(searchKeyWord);

            for(url s : urlList) {
                String tempWeb =  "(" + index + ") " + s.getWebUrl();
                String tempFactor = "score1: "+s.getKeywordScore()+ " & score2: "+s.getExistScore()+ " & score3: "+s.getLinkScore()
                        +" & score4: "+s.getScore4()+ " & PageRank score:"+s.getPageRank();
                searchView.getItems().add(tempWeb);
                searchView.getItems().add(tempFactor);
                index++;
            }
            VBox vboSearch = new VBox(searchText,searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
            HBox hboSearch = new HBox(vboSearch, searchView);
            Scene sceneSearch = new Scene(hboSearch, 1000, 700);
            primaryStage.setScene(sceneSearch);
            primaryStage.show();

            heap Heap = new heap(urlList);

            /**
             * show 20 top web url event -> display the results on the UI interface
             */
            show20webButton.setOnAction((ActionEvent)->{
                ListView<String> top30View = new ListView<>();
                top30View.setPrefSize(800, 700);

                int i = 1;
                Heap.buildMaxHeap(urlList);
                Heap.HeapSort(urlList);  // User print out all web by heapSort method
                /**
                 * 2. a) this loop for  Implement Heap priorit priority queue
                 * to store the first sorted 20 out of 30 web url links into heap
                 */
                ArrayList<url> top20list = new ArrayList<>();
                for(int w = 29; w>9; w--){
                    top20list.add(urlList.get(w));
                }
                for(url s : top20list) {
                    String tempWeb =  "(" + i + ") " + s.getWebUrl();
                    String tempFactor = "score1: "+s.getKeywordScore()+ " & score2: "+s.getExistScore()+ " & score3: "+s.getLinkScore()
                            +" & score4: "+s.getScore4()+ " & PageRank score:"+s.getPageRank();
                    top30View.getItems().add(tempWeb);
                    top30View.getItems().add(tempFactor);
                    i++;
                }
                VBox top30 = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
                HBox hbo30 = new HBox(top30, top30View);
                Scene sceneTop30 = new Scene(hbo30, 1000, 700);
                primaryStage.setScene(sceneTop30);
                primaryStage.show();
            });

            /**
             * insert event -> insert the web url that user required
             */
            insertNewButton.setOnAction((ActionEvent)->{
                ListView<String> addView = new ListView<>();
                addView.setPrefSize(800, 700);
                url added = new url(searchText.getText());
                Heap.MaxHeapInsert(urlList,added);
                int j=1;
                for(url s : urlList) {
                    String tempWeb =  "(" + j + ") " + s.getWebUrl();
                    String tempFactor = "score1: "+s.getKeywordScore()+ " & score2: "+s.getExistScore()+ " & score3: "+s.getLinkScore()
                            +" & score4: "+s.getScore4()+ " & PageRank score:"+s.getPageRank();
                    addView.getItems().add(tempWeb);
                    addView.getItems().add(tempFactor);
                    j++;
                }
                VBox insert = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
                HBox addh = new HBox(insert, addView);
                Scene addScene = new Scene(addh, 1000, 700);
                primaryStage.setScene(addScene);
                primaryStage.show();
            });

            /**
             * get max event -> the user can get the max elment
             */
            getMaxButton.setOnAction((ActionEvent)->{
                ListView<String> maxView = new ListView<>();
                maxView.setPrefSize(800, 700);
                Heap.buildMaxHeap(urlList);
                url max = Heap.heapMaximum(urlList);
                String maxWeb = max.getWebUrl();
                maxWeb = "[max PageRank]: "+maxWeb;
                String tempFactor = "score1: "+max.getKeywordScore()+ " & score2: "+max.getExistScore()+ " & score3: "+max.getLinkScore()
                        +" & score4: "+max.getScore4()+ " & PageRank score:"+max.getPageRank();
                maxView.getItems().add(maxWeb);
                maxView.getItems().add(tempFactor);

                VBox maxvb = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
                HBox maxhb = new HBox(maxvb, maxView);
                Scene maxScene = new Scene(maxhb, 1000, 700);
                primaryStage.setScene(maxScene);
                primaryStage.show();
            });

            /**
             * pick url event -> the user can pick the desired web url
             */
            pickButton.setOnAction((ActionEvent )->{
                ListView<String> pickView = new ListView<>();
                pickView.setPrefSize(800, 700);
                String str = searchText.getText();
                pickIndex = Integer.parseInt(str) - 1;
                url pickUrl = urlList.get(pickIndex);
                String tempUrl = pickUrl.getWebUrl();
                tempUrl = "[Picked Original website]: " + tempUrl;
                String tempFactor = "score1: "+pickUrl.getKeywordScore()+ " & score2: "+pickUrl.getExistScore()+ " & score3: "+pickUrl.getLinkScore()
                        +" & score4: "+pickUrl.getScore4()+ " & PageRank score:"+pickUrl.getPageRank();
                pickView.getItems().add(tempUrl);
                pickView.getItems().add(tempFactor);

                VBox pickvb = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
                HBox pickhb = new HBox(pickvb, pickView);
                Scene pickScene = new Scene(pickhb, 1000, 700);
                primaryStage.setScene(pickScene);
                primaryStage.show();

                /**
                 * paid for AD Event -> user can increase the PageRank for desired web url
                 */
                vipButton.setOnAction((ActionEvent actionEvent)->{

                    ListView<String> vipView = new ListView<>();
                    vipView.setPrefSize(800, 700);
                    String paidMoney = searchText.getText();
                    int increase = Integer.parseInt(paidMoney);

                    for(int p =0; p<urlList.size(); p++){
                        if(p == pickIndex){
                            urlList.get(pickIndex).setPaidScore(increase);
                        }
                    }
                    Heap.buildMaxHeap(urlList);
                    Heap.HeapSort(urlList);

                    int i = 1;
                    for(int v = urlList.size()-1; v>=0; v--){
                        String tempWeb =  "(" + i + ") " + urlList.get(v).getWebUrl();
                        String vipFactor = "score1: "+urlList.get(v).getKeywordScore()+ " & score2: "+urlList.get(v).getExistScore()+ " & score3: "+urlList.get(v).getLinkScore()
                                +" & score4: "+urlList.get(v).getScore4()+ " & PageRank score:"+urlList.get(v).getPageRank();
                        vipView.getItems().add(tempWeb);
                        vipView.getItems().add(vipFactor);
                        i++;
                    }

                    VBox vipvb = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,vipButton);
                    HBox viphb = new HBox(vipvb, vipView);
                    Scene vipScene = new Scene(viphb, 1000, 700);
                    primaryStage.setScene(vipScene);
                    primaryStage.show();
                });
            });
        });

        VBox mainInterface = new VBox(searchText, searchBtn, show20webButton, insertNewButton, getMaxButton, pickButton,
                vipButton, searchBtn1,searchBtn2,searchBtn3,searchBtn4);
        Scene scene = new Scene(mainInterface, 1000, 800);
        primaryStage.setTitle("Google Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){ Application.launch(args); }
}


