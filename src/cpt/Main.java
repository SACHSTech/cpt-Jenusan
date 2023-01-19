package cpt;
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


    public static void main(String[] args) {
        Start = 2020;
        End = 2015;
        TeamTotal = new TeamTotal(Start, End);
        findPlayers = new Hashtable<>(); 

        launch(args);

    }
 

    
    /**
 * A pie chart that provides the ability to drill down through data. Selecting a
 * segment in the initial pie chart causes the pie chart to display detailed data
 * for the selected segment.
 */
    private ObservableList<Data> data;
 
    public Parent createContent() {
        teams = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            TeamData = new Data(TeamTotal.getTeamList().get(i), TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)));
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
        return pie;
    }
 
    private void setDrilldownData(final PieChart pie, final Data data, final String TeamName) {

        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            playerTotal = new PlayerTotal(TeamTotal.getTeamList().get(i), Start, End);

        players = new ArrayList<>();


        for (int x = 0; x < playerTotal.getPlayerCount(); x++){
            playerData = new Data(playerTotal.getNameList().get(x),playerTotal.getTable().get(playerTotal.getNameList().get(x)));
            players.add(playerData);
        }
        findPlayers.put(TeamTotal.getTeamList().get(i), players);
    }

        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            System.out.println(TeamName);
            System.out.println(findPlayers.get(TeamName));
            pie.setData(FXCollections.observableArrayList(findPlayers.get(TeamName)));
        });
    }
 
    @Override public void start(Stage primaryStage) throws Exception { 
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
}