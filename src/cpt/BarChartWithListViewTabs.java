package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartWithListViewTabs extends Application {
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
    XYChart.Series series = new XYChart.Series();
    TextField yearField = new TextField();
    TextField valueField = new TextField();
    Button addButton = new Button("Add");
    ListView<String> dataList = new ListView<>();
    ObservableList<String> data = FXCollections.observableArrayList();
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab();
    Tab tab2 = new Tab();

    @Override
    public void start(Stage stage) {

        dataList.setItems(data);
        dataList.setPrefSize(200, 200);

        HBox inputBox = new HBox();
        inputBox.setSpacing(10);
        inputBox.getChildren().addAll(yearField, valueField, addButton);

        VBox root2 = new VBox();
        root2.setSpacing(10);
        root2.setPadding(new Insets(10, 10, 10, 10));
        root2.getChildren().addAll(bc, inputBox, dataList);
        tab2.setContent(root2);

        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String year = yearField.getText();
                String value = valueField.getText();
                data.add(year + ": " + value);
                series.getData().add(new XYChart.Data(year, Integer.parseInt(value)));
                yearField.clear();
                valueField.clear();
            }
        });

        bc.getData().add(series);

        tabPane.getTabs().addAll(tab1, tab2);
        
        Scene scene  = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
