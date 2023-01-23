package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.*;
import javafx.scene.Group;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import java.util.*;

public class TabSwitcher extends Application {

    static TeamTotal TeamTotal;
    static PlayerTotal playerTotal;

    static Hashtable <String, ArrayList<Data>> findPlayers;
    ArrayList<Data> teams;
    ArrayList<Data> players;
    Data TeamData;
    Data playerData;

    static int Start;
    static int End;
    static int num;

    static BarData barData;

    ArrayList<javafx.scene.chart.XYChart.Data> dataSet;
    ArrayList<Series> dataCollection;
    javafx.scene.chart.XYChart.Data barChartData;
    Series BarChartSeries;

    int yearCount;

    static ArrayList<String> str;

    private ObservableList<Data> data;

    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    static int newValue;

    public static void main(String[] args) {
        Start = 2020;
        End = 1983;
        num = 1979;
        newValue = 1980;
        findPlayers = new Hashtable<>(); 
        str = new ArrayList<>();

        str.add("Giannis Antetokounmpo");
        str.add("Kyle Lowry");

        barData = new BarData(str);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        Tab tab1 = new Tab("Tab 1");

        TeamTotal = new TeamTotal(Start, newValue);

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
        chart.setMaxSize(1000, 1000);
        tab1.setContent(chart);
        
        Tab tab2 = new Tab("Tab 2");
        
        teams = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            TeamData = new Data(TeamTotal.getTeamList().get(i) + " - " + TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)), TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)));
            teams.add(TeamData);
        }

        data = FXCollections.observableArrayList(teams);
        final PieChart pie = new PieChart(data);
        final String drillDownChartCss =
            getClass().getResource("0 DrilldownChart.css").toExternalForm();
        pie.getStylesheets().add(drillDownChartCss);
 
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            setDrilldownData(pie, teams.get(i), TeamTotal.getTeamList().get(i));
        }

        pie.setMaxSize(1000,1000);
        Slider slider = new Slider();
        slider.setMin(1979);
        slider.setMax(2020);
        slider.setValue(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(10);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            //chart.getData().get(0).setPieValue(newValue.doubleValue());
            System.out.println(newValue);
            TeamTotal = new TeamTotal(Start, (int)newValue.doubleValue());
        });
        slider.setMaxSize(1000, 1000);
        slider.setMinWidth(400);
        
        HBox hBox = new HBox(pie, slider);
        HBox.setHgrow(pie, Priority.ALWAYS);
        tab2.setContent(hBox);
        
        tabPane.getTabs().addAll(tab1, tab2);

        StackPane root = new StackPane();
        root.getChildren().addAll(tabPane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Tab Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setDrilldownData(final PieChart pie, final Data data, final String TeamName) {

        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            playerTotal = new PlayerTotal(TeamTotal.getTeamList().get(i), Start, End);

        players = new ArrayList<>();


        for (int x = 0; x < playerTotal.getPlayerCount(); x++){
            playerData = new Data(playerTotal.getNameList().get(x) + " - " + playerTotal.getTable().get(playerTotal.getNameList().get(x)),playerTotal.getTable().get(playerTotal.getNameList().get(x)));
            players.add(playerData);
        }
        findPlayers.put(TeamTotal.getTeamList().get(i), players);
    }

        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            pie.setData(FXCollections.observableArrayList(findPlayers.get(TeamName)));
        });
    }

}
