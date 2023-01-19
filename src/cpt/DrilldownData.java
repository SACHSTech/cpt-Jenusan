package cpt;

import javafx.application.Application;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class DrilldownData extends Application{
    PieChart pie;
    javafx.scene.chart.PieChart.Data data;
    String TeamName;

    DrilldownData(final PieChart pie, final javafx.scene.chart.PieChart.Data data, final String TeamName){
        this.pie = pie;
        this.data = data;
        this.TeamName = TeamName;        
    }

    public PieChart getPie(){
        return this.pie;
    }
    public javafx.scene.chart.PieChart.Data getData(){
        return this.data;
    }
    public String TeamName(){
        return this.TeamName;
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
