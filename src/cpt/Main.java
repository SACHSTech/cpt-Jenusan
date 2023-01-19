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
 
 
public class Main extends Application {
    static TeamTotal TeamTotal;
    static PlayerTotal playerTotal;
    ArrayList<Data> teams;
    ArrayList<Data> players;
    Data TeamData;
    Data playerData;


    public static void main(String[] args) {
        TeamTotal = new TeamTotal(2020, 2015);
        playerTotal = new PlayerTotal("Toronto Raptors");
        
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

        
        Data A;
        A = new Data("A", 100);

        teams.add(A);

        data = FXCollections.observableArrayList(teams);
        final PieChart pie = new PieChart(data);
        final String drillDownChartCss =
            getClass().getResource("0 DrilldownChart.css").toExternalForm();
        pie.getStylesheets().add(drillDownChartCss);
 
        setDrilldownData(pie, A, "a");
        return pie;
    }
 
    private void setDrilldownData(final PieChart pie, final Data data, final String labelPrefix) {

        players = new ArrayList<>();
        for (int i = 0; i < playerTotal.getPlayerCount(); i++){
            playerData = new Data(playerTotal.getNameList().get(i),playerTotal.getTable().get(playerTotal.getNameList().get(i)));
            players.add(playerData);
        }

        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            pie.setData(FXCollections.observableArrayList(players));
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