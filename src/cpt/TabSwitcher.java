package cpt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TabSwitcher extends Application {
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Tab 1");
        tab1.setOnSelectionChanged(e -> {
            if (tab1.isSelected()) {
                tabPane.setStyle("-fx-background-color: blue;");
            }
        });

        
        Tab tab2 = new Tab("Tab 2");
        tab2.setOnSelectionChanged(e -> {
            if (tab2.isSelected()) {
                tabPane.setStyle("-fx-background-color: green;");
            }
        });

        tabPane.getTabs().addAll(tab1, tab2);

        StackPane root = new StackPane();
        root.getChildren().addAll(tabPane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Tab Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
