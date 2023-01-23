package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

public class TabSwitcher1 extends Application {
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
        
        for (final Data data : chart.getData()) {
            data.getNode().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,
                e -> {
                    if (data.getPieValue() > 0) {
                        chart.setTitle("Fruit Distribution - " + data.getName() + " ("+data.getPieValue()+")");
                        ObservableList<PieChart.Data> subData = FXCollections.observableArrayList();
                        subData.add(new PieChart.Data("Green " + data.getName(), data.getPieValue() / 2));
                        subData.add(new PieChart.Data("Yellow " + data.getName(), data.getPieValue() / 2));
                        chart.setData(subData);
                    }
                });
        }
        tab2.setContent(chart);
        tabPane.getTabs().addAll(tab1, tab2);

        Button button1 = new Button("Go to Tab 1");
        button1.setOnAction(e -> tabPane.getSelectionModel().select(tab1));

        Button button2 = new Button("Go to Tab 2");
        button2.setOnAction(e -> tabPane.getSelectionModel().select(tab2));

        StackPane root = new StackPane();
        root.getChildren().addAll(tabPane, button1, button2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Tab Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}