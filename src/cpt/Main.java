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
    ArrayList<Data> test;
    Data TeamData;
    public static void main(String[] args) {
        TeamTotal = new TeamTotal(2020, 2015);
        
        launch(args);
    }
 
    /**
 * A pie chart that provides the ability to drill down through data. Selecting a
 * segment in the initial pie chart causes the pie chart to display detailed data
 * for the selected segment.
 */
    private ObservableList<Data> data;
 
    public Parent createContent() {
        test = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getTeamList().size(); i++){
            TeamData = new Data(TeamTotal.getTeamList().get(i), TeamTotal.getTable().get(TeamTotal.getTeamList().get(i)));
            test.add(TeamData);
        }

        
        Data A, B, C, D;
        A = new Data("A", 0);
        B = new Data("B", 0);
        C = new Data("C", 0);
        D = new Data("D", 0);

        test.add(A);
        test.add(B);
        test.add(C);
        test.add(D);

        data = FXCollections.observableArrayList(test);
        final PieChart pie = new PieChart(data);
        final String drillDownChartCss =
            getClass().getResource("0 DrilldownChart.css").toExternalForm();
        pie.getStylesheets().add(drillDownChartCss);
 
        setDrilldownData(pie, A, "a");
        setDrilldownData(pie, B, "b");
        setDrilldownData(pie, C, "c");
        setDrilldownData(pie, D, "d");
        return pie;
    }
 
    private void setDrilldownData(final PieChart pie, final Data data,
                                  final String labelPrefix) {
        data.getNode().setOnMouseClicked((MouseEvent t) -> {
            pie.setData(FXCollections.observableArrayList(
                    new Data(labelPrefix + "-1", 7),
                    new Data(labelPrefix + "-2", 2),
                    new Data(labelPrefix + "-3", 5),
                    new Data(labelPrefix + "-4", 3),
                    new Data(labelPrefix + "-5", 2)));
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