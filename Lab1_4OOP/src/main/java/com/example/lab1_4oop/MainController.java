package com.example.lab1_4oop;

import groovy.util.Eval;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController {
    @FXML
    public TextField FieldFunction;
    @FXML
    public AnchorPane MainPanel;
    @FXML
    public TextField minValue;
    @FXML
    public TextField maxValue;
    @FXML
    public ComboBox<FunctionProperety> ListFunction;
    public RadioButton showButton;
    public RadioButton hideButton;
    public TextField strokeWidth;
    //-------------------------------------------------------------------------
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    @FXML
    public void initialize() {
        strokeWidth.setText("1.0");
        minValue.setText("0.0");
        maxValue.setText("5.0");
        xAxis.setLabel("Argument");
        yAxis.setLabel("Function");
        lineChart.setTitle("Line Charts");
        lineChart.setLayoutX(0);
        lineChart.setLayoutY(0);
        lineChart.setPrefHeight(400);
        lineChart.setPrefWidth(487);
        lineChart.setCreateSymbols(false);
        /*
        ListFunction.setCellFactory(new Callback<ListView<XYChart.Series>, ListCell<XYChart.Series>>() {
            @Override
            public ListCell<XYChart.Series> call(ListView<XYChart.Series> seriesListView) {
                ListCell<XYChart.Series> cell = new ListCell<XYChart.Series>(){
                    @Override
                    public void updateItem(XYChart.Series series,boolean empty){
                        if(series != null){
                            setText(series.getName());
                        }
                    }
                };
                return cell;
            }
        });
         */
        MainPanel.getChildren().add(lineChart);
        FieldFunction.setOnAction(e -> {
            showButton.setSelected(true);
            double minX = Double.parseDouble(minValue.getText());
            double maxX = Double.parseDouble(maxValue.getText());
            double width = Double.parseDouble(strokeWidth.getText());
            XYChart.Series series = getSeries(minX, maxX, FieldFunction.getText());
            lineChart.getData().add(series);
            ListFunction.getItems().add(new FunctionProperety(FieldFunction.getText(), series, showButton.isSelected(), minX, maxX, width));
            FieldFunction.clear();
            lineChart.lookup(".default-color" + (lineChart.getData().indexOf(series)) + ".chart-series-line").
                    setStyle("-fx-stroke-width: " + width + "px;");
        });
        ListFunction.setOnAction(event -> {
            FunctionProperety func = ListFunction.getSelectionModel().getSelectedItem();
            strokeWidth.setText(func.strokeWidth + "");
            maxValue.setText(func.maxX + "");
            minValue.setText(func.minX + "");
            if (func.visible) {
                showButton.setSelected(true);
            } else {
                hideButton.setSelected(true);
            }
        });
    }

    public void update() {
        FunctionProperety func = ListFunction.getSelectionModel().getSelectedItem();
        if (func != null) {
            func.maxX = Double.parseDouble(maxValue.getText());
            func.minX = Double.parseDouble(minValue.getText());
            func.strokeWidth = Double.parseDouble(strokeWidth.getText());
            func.visible = showButton.isSelected();
            lineChart.getData().remove(func.series);
            if (showButton.isSelected()) {
                XYChart.Series series = getSeries(func.minX, func.maxX, func.function);
                lineChart.getData().add(series);
                func.series = series;
            }
        }
    }

    public void setStrokeWidth() {
        if (ListFunction.getSelectionModel().getSelectedItem() != null) {
            System.out.println(lineChart.getData().indexOf(ListFunction.getSelectionModel().getSelectedItem().series));
            lineChart.lookup(".default-color" + (lineChart.getData().indexOf(ListFunction.getSelectionModel().getSelectedItem().series)) + ".chart-series-line").
                    setStyle("-fx-stroke-width: " + strokeWidth.getText() + "px;");
        }
    }

    private XYChart.Series getSeries(double minX, double maxX, String function) {
        XYChart.Series series = new XYChart.Series();
        series.setName(function);
        for (double x = minX; x < maxX; x += (maxX - minX) / 50) {
            double y = (double) Eval.x(x, function);
            series.getData().add(new XYChart.Data(x, y));
        }
        return series;
    }

    private class FunctionProperety {
        String function = "";
        XYChart.Series<Number, Number> series;
        boolean visible = false;
        double minX = 0;
        double maxX = 0;
        double strokeWidth = 0;

        FunctionProperety(String function, XYChart.Series<Number, Number> series, boolean visible, double minX, double maxX, double strokeWidth) {
            this.function = function;
            this.series = series;
            this.visible = visible;
            this.minX = minX;
            this.maxX = maxX;
            this.strokeWidth = strokeWidth;
        }

        @Override
        public String toString() {
            return function;
        }
    }
}
