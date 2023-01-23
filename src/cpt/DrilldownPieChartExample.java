package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrilldownPieChartExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PieChart chart = new PieChart();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Slice 1", 25),
                        new PieChart.Data("Slice 2", 75)
                );
        chart.setData(pieChartData);
        chart.setTitle("Example Pie Chart");

        // Add a click event listener to each slice
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // Update the chart with new data when a slice is clicked
                    ObservableList<PieChart.Data> newData = FXCollections.observableArrayList(
                            new PieChart.Data("New Slice 1", 50),
                            new PieChart.Data("New Slice 2", 50)
                    );
                    chart.setData(newData);
                    chart.setTitle("Drilldown Pie Chart");
                }
            });
        }

        StackPane root = new StackPane();
        root.getChildren().add(chart);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("JavaFX Drilldown Pie Chart Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
