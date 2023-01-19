
package cpt;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
 
import java.util.Arrays;
 
/**
 * A sample that demonstrates the Spinner control.
 */
public class SpinnerApp extends Application {
 
    /**
     * Java main for when running without JavaFX launcher
     */

     static int num;

    public static void main(String[] args) {
        num = 1979;
        Application.launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(num);
        primaryStage.setScene(new Scene(createContent()));
        System.out.println(num);
        primaryStage.show();
        System.out.println(num);
    }
 
    public Parent createContent() {
 
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(1);
        tilePane.setPrefRows(1);
        tilePane.setHgap(20);
        tilePane.setVgap(30);
 
        Pane root = new Pane();
        root.setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        root.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
 
            /* Integer spinners */
            SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(num, 2020);
            Spinner sp = new Spinner();
            sp.setValueFactory(svf);
            sp.getStyleClass().add("spinner");
            sp.setPrefWidth(80);
            tilePane.getChildren().add(sp);

 
        root.getChildren().add(tilePane);
        return root;
    }
}