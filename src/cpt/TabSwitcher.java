package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class TabSwitcher extends Application {
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        Tab tab1 = new Tab("Tab 1");
        
        Tab tab2 = new Tab("Tab 2");
        
        //Creating a Pie chart 
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Apple", 20),
            new PieChart.Data("Banana", 30),
            new PieChart.Data("Orange", 10),
            new PieChart.Data("Mango", 15),
            new PieChart.Data("Grape", 25));

            
        
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Fruit Distribution");

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(20);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(10);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            //chart.getData().get(0).setPieValue(newValue.doubleValue());
            pieChartData.get(0).setName(newValue.toString());
        });
        
        VBox vBox = new VBox(chart,slider);
        tab2.setContent(vBox);
        
        
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
