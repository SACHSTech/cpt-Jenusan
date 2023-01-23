package cpt;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrilldownPieChart extends Application {

    private PieChart chart;
    private PieChart originalChart;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        chart = new PieChart();
        chart.getData().addAll(
                new PieChart.Data("Item 1", 20),
                new PieChart.Data("Item 2", 30),
                new PieChart.Data("Item 3", 50)
        );

        originalChart = chart;

        chart.getData().forEach(data ->
                data.getNode().setOnMouseClicked(e -> {
                    PieChart newChart = new PieChart();
                    newChart.getData().addAll(
                            new PieChart.Data("Subitem 1", 10),
                            new PieChart.Data("Subitem 2", 20),
                            new PieChart.Data("Subitem 3", 40)
                    );
                    chart = newChart;
                })
        );

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chart = originalChart;
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(chart, resetButton);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Drilldown Pie Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
