package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PieChartExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the pie chart data
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Apple", 50),
                        new PieChart.Data("Banana", 30),
                        new PieChart.Data("Orange", 20));

        // Create the pie chart
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Fruits");

        // Create the slider
        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        // Add the pie chart and slider to a HBox
        HBox root = new HBox();
        root.getChildren().addAll(pieChart, slider);

        // Create the scene and show the stage
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Pie Chart and Slider Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
