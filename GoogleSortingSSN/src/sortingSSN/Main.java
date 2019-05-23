package sortingSSN;
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
import java.io.IOException;
import java.util.ArrayList;
/**
 * A Main class to implement all Handling events for Sorting Social Security Numbers
 * This class is using Javafx library to implement User Interface
 * The goal is to let all users to fell more intuitive than display on console
 */
public class Main extends Application {

    private ArrayList<String> homeList = new ArrayList<>();
    private ArrayList<String> quicklist = new ArrayList<>();
    private ArrayList<String> bucketlist = new ArrayList<>();
    private ArrayList<String> radixlist = new ArrayList<>();
    private Button homeBtn;    //generate 300 random SSN numbers
    private Button quickBtn;
    private Button bucketBtn;
    private Button radixBtn;
    private static TextField inputText;

    /**
     * @param primaryStage the primary stage
     * @throws FileNotFoundException if the reading or writing file doesn't find, it will throw the exception
     */
    public void start(Stage primaryStage) throws FileNotFoundException {
        inputText = new TextField("input Social Security Number: ");
        inputText.setPrefSize(200, 30);

        //added a home button icon into the button
        FileInputStream input = new FileInputStream("home.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        homeBtn = new Button("Search", imageView);
        homeBtn.setPrefSize(200, 30);

        //added a quickSort button icon into the button
        FileInputStream input1 = new FileInputStream("android.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        quickBtn = new Button("QuickSort", imageView1);
        quickBtn.setPrefSize(200, 30);

        //added a bucketSort button icon into the button
        FileInputStream input2 = new FileInputStream("android.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        bucketBtn = new Button("BucketSort", imageView2);
        bucketBtn.setPrefSize(200, 30);

        //added a radixSort button icon into the button
        FileInputStream input3 = new FileInputStream("android.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        radixBtn = new Button("RadixSort", imageView3);
        radixBtn.setPrefSize(200, 30);

        /**
         * home button -> event driven, it will generate 300 SSN numbers to display on primary screen
         */
        homeBtn.setOnAction((ActionEvent event)-> {
            ListView<String> homeView = new ListView<>();
            homeView.setPrefSize(600, 600);
            extractSSN essn = new extractSSN();
            /**
             * only one statement inside try clause: This method offers the highest possible degree of encapsulation;
             * see it encapsulating in extractSSN class's generateToRandom_SSN() method.
             */
            try{ //try to convert strings into a ArrayList, then we can call listView to add every element
                homeList = essn.generateToRandom_SSN();
            }catch(IOException e){ // if failed to read from .txt file, then System will catch the exception

            }
            for(String s : homeList) {
                homeView.getItems().add(s);
            } //ArrayList homeView will add every record of ssn on the UI from up to down

            VBox vboSearch = new VBox(inputText, homeBtn, quickBtn, bucketBtn, radixBtn);
            HBox hboSearch = new HBox(vboSearch, homeView);
            Scene sceneSearch = new Scene(hboSearch, 800, 600);
            primaryStage.setScene(sceneSearch);
            primaryStage.show();
        });

        /**
         * quickBtn this event that call the quickSort() to sort the picked arrayList
         */
        quickBtn.setOnAction((ActionEvent event)->{
            ListView<String> quickView = new ListView<>();
            quickView.setPrefSize(600,600);
            extractSSN essn = new extractSSN();
            /**
             * only two statement inside try clause: This method offers the highest possible degree of encapsulation;
             * see it encapsulating in extractSSN class's quickSortToFile() and quickSortToUI method.
             */
            try{
                essn.quickSortToFile();
                quicklist = essn.quickSortToUI();
            }catch (IOException e){ // if failed to read from .txt file, then System will catch the exception

            }

            // the area name and people's number will display on the User Interface
            quickView.getItems().add("Northeast Coast States: "+ essn.getNecsPeople()+" people");
            quickView.getItems().add("South Coast States: "+ essn.getScsPeople()+" people");
            quickView.getItems().add("Middle States: "+ essn.getMsPeople()+" people");
            quickView.getItems().add("Northwest Coast States: "+ essn.getNwcsPeople()+" people");
            quickView.getItems().add("West Coast States: "+ essn.getWcsPeople()+" people");
            quickView.getItems().add(" ^_^ The following is SSN number in QuickSort order: ");
            quickView.getItems().add("*****************************************************");
            for(String s : quicklist){
                quickView.getItems().add(s);
            } //ArrayList quickView will add every record of ssn on the UI from up to down
            VBox vqSort = new VBox(inputText, homeBtn, quickBtn, bucketBtn, radixBtn);
            HBox hboSort = new HBox(vqSort, quickView);
            Scene sceneQuick = new Scene(hboSort, 800, 600);
            primaryStage.setScene(sceneQuick);
            primaryStage.show();
        });

        /**
         * bucketBtn this event that call the bucketSort() to sort the picked arrayList
         */
        bucketBtn.setOnAction((ActionEvent event)->{
            ListView<String> bucketView = new ListView<>();
            bucketView.setPrefSize(600,600);
            extractSSN essn = new extractSSN();
            /**
             * only two statement inside try clause: This method offers the highest possible degree of encapsulation;
             * see it encapsulating in extractSSN class's bucketSortToFile() and bucketToUI method.
             */
            try{
                essn.bucketSortToFile();
                bucketlist = essn.bucketSortToUI();
            }catch (IOException e){ // if failed to read from .txt file, then System will catch the exception

            }

            // the area name and people's number will display on the User Interface
            bucketView.getItems().add("Northeast Coast States: "+ essn.getNecsPeople()+" people");
            bucketView.getItems().add("South Coast States: "+ essn.getScsPeople()+" people");
            bucketView.getItems().add("Middle States: "+ essn.getMsPeople()+" people");
            bucketView.getItems().add("Northwest Coast States: "+ essn.getNwcsPeople()+" people");
            bucketView.getItems().add("West Coast States: "+ essn.getWcsPeople()+" people");
            bucketView.getItems().add(" ^_^ The following is SSN number in BucketSort order: ");
            bucketView.getItems().add("*****************************************************");
            for(String s : bucketlist){
                bucketView.getItems().add(s);
            } //ArrayList bucketView will add every record of ssn on the UI from up to down

            VBox vqSort = new VBox(inputText, homeBtn, quickBtn, bucketBtn, radixBtn);
            HBox hboSort = new HBox(vqSort, bucketView);
            Scene sceneBucket = new Scene(hboSort, 800, 600);
            primaryStage.setScene(sceneBucket);
            primaryStage.show();

        });

        /**
         * radixBtn this event that call the radixSort() to sort the picked arrayList
         */
        radixBtn.setOnAction((ActionEvent event)->{
            ListView<String> radixView = new ListView<>();
            radixView.setPrefSize(600,600);
            extractSSN essn = new extractSSN();
            /**
             * only two statement inside try clause: This method offers the highest possible degree of encapsulation;
             * see it encapsulating in extractSSN class's radixSortToFile() and radixSortToUI method.
             */
            try{
                essn.radixSortToFile();
                radixlist = essn.radixSortToUI();
            }catch (IOException e){ // if failed to read from .txt file, then System will catch the exception

            }

            // the area name and people's number will display on the User Interface
            radixView.getItems().add("Northeast Coast States: "+ essn.getNecsPeople()+" people");
            radixView.getItems().add("South Coast States: "+ essn.getScsPeople()+" people");
            radixView.getItems().add("Middle States: "+ essn.getMsPeople()+" people");
            radixView.getItems().add("Northwest Coast States: "+ essn.getNwcsPeople()+" people");
            radixView.getItems().add("West Coast States: "+ essn.getWcsPeople()+" people");
            radixView.getItems().add(" ^_^ The following is SSN number in BucketSort order: ");
            radixView.getItems().add("*****************************************************");
            for(String s : radixlist){
                radixView.getItems().add(s);
            } //ArrayList radixView will add every record of ssn on the UI from up to down

            VBox vqSort = new VBox(inputText, homeBtn, quickBtn, bucketBtn, radixBtn);
            HBox hboSort = new HBox(vqSort, radixView);
            Scene sceneRadix = new Scene(hboSort, 800, 600);
            primaryStage.setScene(sceneRadix);
            primaryStage.show();

        });

        VBox mainInterface = new VBox(inputText,homeBtn, quickBtn, bucketBtn, radixBtn);
        Scene scene = new Scene(mainInterface, 600, 400);
        primaryStage.setTitle("Sorting SSN Engine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){ Application.launch(args); }
}
