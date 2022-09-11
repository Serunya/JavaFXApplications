package com.example.lab1_5oop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProgramLanguage {
    SimpleStringProperty language;
    SimpleStringProperty firstName;
    SimpleStringProperty secondName;
    IntegerProperty year;

    ProgramLanguage(String language, String firstName, String secondName, int year) {
        this.language = new SimpleStringProperty(language);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.year = new SimpleIntegerProperty(year);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
