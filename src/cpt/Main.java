package cpt;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.*;
import javafx.scene.layout.HBox;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Main extends Application {

    //initializing a lot of variables
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

    ArrayList<javafx.scene.chart.XYChart.Data> dataSet;
    ArrayList<Series> dataCollection;
    javafx.scene.chart.XYChart.Data barChartData;
    Series BarChartSeries;

    int yearCount;

    String str;

    private ObservableList<Data> data;

    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    final CategoryAxis BarxAxis = new CategoryAxis();
    final NumberAxis BaryAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
        new BarChart<String,Number>(BarxAxis,BaryAxis);
    XYChart.Series series = new XYChart.Series();
    TextField yearField = new TextField();
    TextField valueField = new TextField();
    Button addButton = new Button("Add");
    ListView<String> dataList = new ListView<>();
    ObservableList<String> Bardata = FXCollections.observableArrayList();
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab();
    Tab tab2 = new Tab();

    SinglePlayer singlePlayer;

    static int newValue;

    /**
     * main method to run code
     */
    public static void main(String[] args) {
        Start = 2020;
        End = 1983;
        findPlayers = new Hashtable<>(); 

        launch(args);
    }

    
    @Override
    /**
     * start method
     */
    public void start(Stage primaryStage) {
        // initializes tabs
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Bar Chart");

        // sends in data for barchart
        dataList.setItems(Bardata);


        dataList.setPrefSize(200, 200);

        // constructs the barchart with given data
        HBox inputBox = new HBox();
        inputBox.setSpacing(10);
        inputBox.getChildren().addAll(yearField, addButton);
        VBox Barroot = new VBox();
        Barroot.setSpacing(10);
        Barroot.setPadding(new Insets(10, 10, 10, 10));
        Barroot.getChildren().addAll(bc, inputBox, dataList);
        tab1.setContent(Barroot);

        // Adds new data when add button is pressed
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    String year = yearField.getText();
                    singlePlayer = new SinglePlayer(year);

                    if (singlePlayer.totals.get(year) != null){
                        Bardata.add(year);
                        series.getData().add(new XYChart.Data(year, singlePlayer.totals.get(year)));
                    }else{
                        Bardata.add(year + " (***Invalid Name***)");
                    }
                    yearField.clear();
            }
        });

        bc.getData().add(series);

        // second tab code
        Tab tab2 = new Tab("Pie Chart");

        TeamTotal = new TeamTotal(Start, End);
        
        // puts data into arraylist of constructors
        teams = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            TeamData = new Data(TeamTotal.getTeamList().get(i) + " - " + TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)), TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)));
            teams.add(TeamData);
        }

        data = FXCollections.observableArrayList(teams);
        final PieChart pie = new PieChart(data);

        // perams for the pie chart
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(10);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            End = (int)newValue.doubleValue();
            pie.getData().get(0).setPieValue(End);
        });
        slider.setMaxSize(1000, 1000);
        slider.setMinWidth(400);


        final String drillDownChartCss =
            getClass().getResource("0 DrilldownChart.css").toExternalForm();
        pie.getStylesheets().add(drillDownChartCss);
 
        // sets drilldown data
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            setDrilldownData(pie, teams.get(i), TeamTotal.getTeamList().get(i));
        }
        
        // sets tab
        tab2.setContent(pie);
        

        // peices togethere and sets final scene
        tabPane.getTabs().addAll(tab1, tab2);

        StackPane root = new StackPane();
        root.getChildren().addAll(tabPane);

        Scene scene = new Scene(root, 1400, 900);

        primaryStage.setTitle("Tab Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * drilldownn data for pie chart
     * @param pie chart
     * @param data data for chart
     * @param TeamName teamname string
     */
    private void setDrilldownData(final PieChart pie, final Data data, final String TeamName) {

        // cuts down to teamd
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            playerTotal = new PlayerTotal(TeamTotal.getTeamList().get(i), Start, End);

        players = new ArrayList<>();


        // cuts down to players
        for (int x = 0; x < playerTotal.getPlayerCount(); x++){
            playerData = new Data(playerTotal.getNameList().get(x) + " - " + playerTotal.getTable().get(playerTotal.getNameList().get(x)),playerTotal.getTable().get(playerTotal.getNameList().get(x)));
            players.add(playerData);
        }
        findPlayers.put(TeamTotal.getTeamList().get(i), players);
    }

    // finds where users click
        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            pie.setData(FXCollections.observableArrayList(findPlayers.get(TeamName)));
        });
    }

}