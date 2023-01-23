package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        listView.setItems(items);

        // Add a listener to detect when an item is selected
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected item: " + newValue);
        });

        StackPane root = new StackPane();
        root.getChildren().add(listView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("ListView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
