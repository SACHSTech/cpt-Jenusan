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
import javafx.scene.layout.Priority;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
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

public class Main extends Application {

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

    String str;

    private ObservableList<Data> data;

    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    final CategoryAxis BarxAxis = new CategoryAxis();
    final NumberAxis BaryAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
    XYChart.Series series = new XYChart.Series();
    TextField yearField = new TextField();
    Button addButton = new Button("Add");
    ListView<String> dataList = new ListView<>();
    ObservableList<String> Bardata = FXCollections.observableArrayList();

    singlePlayer singlePlayer;

    static int newValue;

    public static void main(String[] args) {
        Start = 2020;
        End = 1983;
        findPlayers = new Hashtable<>(); 

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Tab 1");

        dataList.setItems(Bardata);
        barData = new BarData();

        dataList.setPrefSize(200, 200);

        HBox inputBox = new HBox();
        inputBox.setSpacing(10);
        inputBox.getChildren().addAll(yearField, addButton);

        VBox Barroot = new VBox();
        Barroot.setSpacing(10);
        Barroot.setPadding(new Insets(10, 10, 10, 10));
        Barroot.getChildren().addAll(bc, inputBox, dataList);
        tab1.setContent(Barroot);

        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    String year = yearField.getText();
                    singlePlayer = new singlePlayer(year);
                    Bardata.add(year);

                    if (singlePlayer.totals.get(year) != null){
                        series.getData().add(new XYChart.Data(year, singlePlayer.totals.get(year)));
                    }
                    yearField.clear();
            }
        });

        bc.getData().add(series);

        //Scene Barscene  = new Scene(Barroot, 800, 600);
        
        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////

        Tab tab2 = new Tab("Tab 2");

        TeamTotal = new TeamTotal(Start, End);
        
        teams = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            TeamData = new Data(TeamTotal.getTeamList().get(i) + " - " + TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)), TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)));
            teams.add(TeamData);
        }

        data = FXCollections.observableArrayList(teams);
        final PieChart pie = new PieChart(data);

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
 
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            setDrilldownData(pie, teams.get(i), TeamTotal.getTeamList().get(i));
        }
        
        tab2.setContent(pie);
        
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