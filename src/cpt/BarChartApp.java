package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.*;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {

    static BarData barData;

    ArrayList<BarChart.Data> dataSet;
    ArrayList<BarChart.Series> dataCollection;
    BarChart.Data BarChartData;
    BarChart.Series BarChartSeries;
    



    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();

        str.add("Norman Powell");
        str.add("Giannis Antetokounmpo");

        barData = new BarData(str);
        
        launch(args);
    }
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent createContent() {
        dataSet = new ArrayList<>();
        dataCollection = new ArrayList<>();

        BarChartData = new BarChart.Data("2016", 8);
        dataSet.add(BarChartData);
        BarChartData = new BarChart.Data("2015", 8);
        dataSet.add(BarChartData);

        BarChartSeries = new BarChart.Series("trgh", FXCollections.observableArrayList(dataSet));
        dataCollection.add(BarChartSeries);
        //dataCollection.add(BarChartSeries);
        
        String[] years = barData.getYears();
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 10, 1000.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Apples",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 567d),
                    new BarChart.Data(years[1], 1292d),
                    new BarChart.Data(years[2], 1292d))),
                    new BarChart.Series("Apples",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 567d),
                    new BarChart.Data(years[1], 1292d),
                    new BarChart.Data(years[2], 1292d))),
                new BarChart.Series("Oranges",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 1154),
                    new BarChart.Data(years[1], 1927),
                    new BarChart.Data(years[2], 2774)))
            );


        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

}