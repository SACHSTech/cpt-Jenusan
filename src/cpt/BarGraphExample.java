package cpt;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BarGraphExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a table view to display the data
        TableView<Data> table = new TableView<>();

        // Create columns for the table
        table.getColumns().addAll(createColumn("Name", Data::nameProperty),
                createColumn("Value", Data::valueProperty));

        // Add sample data to the table
        table.setItems(getSampleData());

        // Create a bar chart to display the selected data
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Name");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        // Add an event listener to the table to update the bar chart when a row is selected
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName("Selected Data");
                series.getData().add(new XYChart.Data<>(newSelection.getName(), newSelection.getValue()));
                barChart.getData().clear();
                barChart.getData().add(series);
            }
        });

        // Add the table and bar chart to the scene
        StackPane root = new StackPane();
        root.getChildren().addAll(table, barChart);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Data> getSampleData() {
        return FXCollections.observableArrayList(
                new Data("Item 1", 10),
                new Data("Item 2", 20),
                new Data("Item 3", 30),
                new Data("Item 4", 40)
        );
    }

    private <S, T> TableColumn<S, T> createColumn(String title, Function<S, Property<T>> property) {
        TableColumn<S, T> column = new TableColumn<>(title);
        column.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return column;
    }

    public static class Data {
        private StringProperty name = new SimpleStringProperty();
        private IntegerProperty value = new SimpleIntegerProperty();

        public Data(String name, int value) {
            setName(name);
            setValue(value);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public int getValue() {
            return value.get();
        }

        public void setValue(int value) {
            this.value.set(value);
        }

        public IntegerProperty valueProperty() {
            return value;
        }
    }
}

