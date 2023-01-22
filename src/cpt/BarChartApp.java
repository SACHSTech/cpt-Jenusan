package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import java.util.*;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {

    static BarData barData;

    ArrayList<Data> dataSet;
    ArrayList<Series> dataCollection;
    Data barChartData;
    Series BarChartSeries;

    int yearCount;

    static ArrayList<String> str;
    


    public static void main(String[] args) {
        str = new ArrayList<>();

        str.add("LeBron James");
        str.add("Giannis Antetokounmpo");
        str.add("Kyle Lowry");

        barData = new BarData(str);

        barData.print();

        
        launch(args);
    }
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent createContent() {
        dataCollection = new ArrayList<>();

        for (int i = 0; i < barData.playerstats.size(); i++){
            dataSet = new ArrayList<>();
            for (int x = 0; x < barData.yearTotalCollection.get(i).size(); x++){
                barChartData = new BarChart.Data(barData.yearList.get(yearCount), barData.yearTotalCollection.get(i).get(barData.yearList.get(yearCount)));
                dataSet.add(barChartData);

                yearCount++;
            }
            BarChartSeries = new BarChart.Series(barData.getPlayerList().get(i), FXCollections.observableArrayList(dataSet));
            dataCollection.add(BarChartSeries);
        }

        
        String[] years = barData.getYears();


        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Player Of The Weeks", 0.0d, barData.getMax() * 1.1 , 10.0d);
        ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList(dataCollection);


        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

}