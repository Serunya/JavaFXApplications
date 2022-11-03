package com.example.lab1_5oop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

public class Application extends javafx.application.Application {
    ObservableList<ProgramLanguage> tableData = FXCollections.observableArrayList(
            new ProgramLanguage("C", "Деннис", "Ритчи", 1972),
            new ProgramLanguage("C++", "Бьерн", "Гослинг", 1995),
            new ProgramLanguage("JavaScript", "Брендон", "Айк", 1995),
            new ProgramLanguage("C#", "Андрес", "Хейлсберг", 2001),
            new ProgramLanguage("Scale", "Мартин", "Одерски", 2003)
    );
    private TableView<ProgramLanguage> table = new TableView<>(tableData);
    @FXML
    private AnchorPane mainPanel;

    @Override
    public void start(Stage stage) throws IOException {
        RadioButton firstNameButton = new RadioButton();
        firstNameButton.setLayoutX(510);
        firstNameButton.setLayoutY(30);
        firstNameButton.setSelected(true);
        firstNameButton.setText("Имя");

        RadioButton secondNameButton = new RadioButton();
        secondNameButton.setLayoutX(510);
        secondNameButton.setLayoutY(60);
        secondNameButton.setSelected(true);
        secondNameButton.setText("Фамилия");

        RadioButton languageButton = new RadioButton();
        languageButton.setLayoutX(510);
        languageButton.setLayoutY(90);
        languageButton.setSelected(true);
        languageButton.setText("Язык");

        RadioButton yearButton = new RadioButton();
        yearButton.setLayoutX(510);
        yearButton.setLayoutY(120);
        yearButton.setSelected(true);
        yearButton.setText("Год");

        TextField firstNameEntry = new TextField();
        firstNameEntry.setPromptText("Имя");
        firstNameEntry.setLayoutY(430);
        firstNameEntry.setLayoutX(5);
        firstNameEntry.setPrefWidth(100);
        TextField secondNameEntry = new TextField();
        secondNameEntry.setPromptText("Фамилия");
        secondNameEntry.setLayoutY(430);
        secondNameEntry.setLayoutX(115);
        secondNameEntry.setPrefWidth(100);
        TextField languageEntry = new TextField();
        languageEntry.setPromptText("Язык");
        languageEntry.setLayoutY(430);
        languageEntry.setLayoutX(225);
        languageEntry.setPrefWidth(100);
        TextField yearEntry = new TextField();
        yearEntry.setPromptText("Год");
        yearEntry.setLayoutY(430);
        yearEntry.setLayoutX(335);
        yearEntry.setPrefWidth(70);

        Button addButton = new Button();
        addButton.setText("Добавить");
        addButton.setLayoutY(430);
        addButton.setLayoutX(415);
        addButton.setPrefWidth(70);
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    tableData.add(new ProgramLanguage(firstNameEntry.getText(),
                            secondNameEntry.getText(),
                            languageEntry.getText(),
                            Integer.parseInt(yearEntry.getText())));
                    firstNameEntry.clear();
                    secondNameEntry.clear();
                    languageEntry.clear();
                    yearEntry.clear();
                } catch (NumberFormatException e) {
                    System.out.println("Whats wrong");
                }
            }
        });

        //Таблица
        table.setPrefWidth(500);
        table.setPrefHeight(400);
        TableColumn<ProgramLanguage, String> firstNameColumn = new TableColumn<>("Имя");
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstName);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProgramLanguage, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ProgramLanguage, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirstName(t.getNewValue());
            }
        });
        TableColumn<ProgramLanguage, String> secondNameColumn = new TableColumn<>("Фамилия");
        secondNameColumn.setCellValueFactory(cellData -> cellData.getValue().secondName);
        secondNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        secondNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProgramLanguage, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ProgramLanguage, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSecondName(t.getNewValue());
            }
        });
        TableColumn<ProgramLanguage, String> langugeColumn = new TableColumn<>("Язык");
        langugeColumn.setCellValueFactory(cellData -> cellData.getValue().language);
        langugeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        langugeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProgramLanguage, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ProgramLanguage, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLanguage(t.getNewValue());
            }
        });
        TableColumn<ProgramLanguage, Integer> yearColumn = new TableColumn<>("Год");
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().year.asObject());
        yearColumn.setCellFactory(TextFieldTableCell.<ProgramLanguage, Integer>forTableColumn(new IntegerStringConverter()));
        yearColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProgramLanguage, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ProgramLanguage, Integer> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setYear(t.getNewValue());
            }
        });
        table.getColumns().add(firstNameColumn);
        table.getColumns().add(secondNameColumn);
        table.getColumns().add(langugeColumn);
        table.getColumns().add(yearColumn);
        firstNameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (firstNameButton.isSelected())
                    firstNameColumn.setVisible(true);
                else
                    firstNameColumn.setVisible(false);
            }
        });
        secondNameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (secondNameButton.isSelected())
                    secondNameColumn.setVisible(true);
                else
                    secondNameColumn.setVisible(false);
            }
        });

        languageButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (languageButton.isSelected())
                    langugeColumn.setVisible(true);
                else
                    langugeColumn.setVisible(false);
            }
        });
        yearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (yearButton.isSelected())
                    yearColumn.setVisible(true);
                else
                    yearColumn.setVisible(false);
            }
        });
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Основная панель
        AnchorPane root = new AnchorPane(table, firstNameButton, secondNameButton, languageButton, yearButton,
                firstNameEntry, secondNameEntry, languageEntry, yearEntry, addButton);
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        table.setEditable(true);
        stage.setTitle("Языки программирования");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

