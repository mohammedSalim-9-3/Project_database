package com.example.prolabmo;

import javafx.fxml.FXML;

import java.io.IOException;

public class HomeController {
    @FXML
    private void switchToDepartment() throws IOException {
        ProjectDataBase.setRoot("Departments");
    }
    @FXML
    private void switchToDoctors() throws IOException {
        ProjectDataBase.setRoot("Doctors");
    }
    @FXML
    private void switchToPatients() throws IOException {
        ProjectDataBase.setRoot("Patients");
    }
    @FXML
    private void switchToVisits() throws IOException {
        ProjectDataBase.setRoot("Visits");
    }
}