package com.example.prolabmo;

import CheakConnection.DBQuery;
import CheakConnection.cheakException;
import Clases.CDepartments;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DepartmentsController implements Initializable {
 // Start Methods

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showDepartment();

    }

    private void showDepartment()  {
        ObservableList<CDepartments> list = DBQuery.selectDepartment();
        colId.setCellValueFactory(new PropertyValueFactory<CDepartments , Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<CDepartments , String>("name"));
        tvDep.setItems(list);
    }
    @FXML
    private void Previous() throws IOException {
        ProjectDataBase.setRoot("Home");
    }


    @FXML
    private void insertRecorde () {
        boolean cheak = DBQuery.SearchDepartment(Integer.parseInt(tfId.getText()));
        if (cheak == true) {
            cheakException.errorMessageID();
        } else if (tfId.getText().length() > 6 || tfName.getText().length() > 10) {
              cheakException.errorMessageValueBig();
        }
        else {

            DBQuery.insertDepartment(Integer.parseInt(tfId.getText()), tfName.getText());
            showDepartment();
        }
    }



    @FXML
    private void updateRecord () {
         if (tfName.getText().length() > 10) {
            cheakException.errorMessageValueBig();
        }

        DBQuery.updateDepartment(Integer.parseInt(tfId.getText()) , tfName.getText());
        showDepartment();
    }
    @FXML
    private void deleteRecord () {
        DBQuery.deleteDepartment(Integer.parseInt(tfId.getText()));
        showDepartment();
    }
    // END Methods

    // Declare Varible

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfName;
    @FXML
    private TableView<CDepartments> tvDep;
    @FXML
    private TableColumn<CDepartments , Integer> colId;
    @FXML
    private TableColumn<CDepartments , String> colName;
   @FXML
    private Button btnUpd;
    // End Declare Varible

}