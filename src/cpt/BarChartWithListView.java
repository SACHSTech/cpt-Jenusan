package cpt;

import java.util.ArrayList;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartWithListView extends Application {
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
    XYChart.Series series = new XYChart.Series();
    TextField yearField = new TextField();
    Button addButton = new Button("Add");
    ListView<String> dataList = new ListView<>();
    ObservableList<String> data = FXCollections.observableArrayList();

    BarData barData;
    singlePlayer singlePlayer;
    ArrayList<String> players;

    @Override
    public void start(Stage stage) {
        dataList.setItems(data);
        barData = new BarData();
        players = new ArrayList<>();

        dataList.setPrefSize(200, 200);

        HBox inputBox = new HBox();
        inputBox.setSpacing(10);
        inputBox.getChildren().addAll(yearField, addButton);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(bc, inputBox, dataList);

        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    String year = yearField.getText();
                    singlePlayer = new singlePlayer(year);
                    data.add(year);
                    try{
                        series.getData().add(new XYChart.Data(year, singlePlayer.totals.get(year)));
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    yearField.clear();
                }catch(Exception e){
                    System.out.println("no");
                }
            }
        });

        bc.getData().add(series);

        Scene scene  = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
