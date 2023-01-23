package com.example.prolabmo;

import CheakConnection.DBQuery;
import CheakConnection.cheakException;
import Clases.CDoctors;
import Clases.CPatients;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.ResourceBundle;

public class PatientsController implements Initializable {

    @FXML
    private void Previous() throws IOException {
        ProjectDataBase.setRoot("Home");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showPatient();

    }

    private void showPatient() {
        ObservableList<CPatients> list = DBQuery.selectPatients();
        colId.setCellValueFactory(new PropertyValueFactory<CPatients , Integer>("id"));
        colFname.setCellValueFactory(new PropertyValueFactory<CPatients , String>("Fname"));
        colLname.setCellValueFactory(new PropertyValueFactory<CPatients , String>("Lname"));
        colDeptName.setCellValueFactory(new PropertyValueFactory<CPatients , String>("dept_name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<CPatients , Integer>("phone"));
        colNots.setCellValueFactory(new PropertyValueFactory<CPatients , String>("nots"));
        tvPat.setItems(list);
    }
    @FXML
    private void insertPatient () {
        // Remember cheak dec not found -------- cheak dep found
        boolean cheakDept = DBQuery.SearchDepartment(Integer.parseInt(tfDeptID.getText()));

        if (cheakDept == false)  {
            cheakException.errorMessage();
        }else if (tfId.getText().length() > 6 || tfFname.getText().length() > 10) {
            cheakException.errorMessageValueBig();
        }
        else {

            DBQuery.insertPatients(Integer.parseInt(tfId.getText()), tfFname.getText() , tfLname.getText() ,
                    Integer.parseInt(tfPhone.getText()) , Integer.parseInt(tfDeptID.getText()) ,
                    tfNots.getText());
                showPatient();

        }
    }
    @FXML
    public void updatePatient () {
        DBQuery.updatePatients(Integer.parseInt(tfId.getText()) , tfFname.getText() ,
                tfLname.getText() , Integer.parseInt(tfPhone.getText()) , tfNots.getText());
        showPatient();
    }

    @FXML
    public void deletePatient () {
        DBQuery.deletePatients(Integer.parseInt(tfId.getText()));
        showPatient();
    }

    @FXML
    public TextField tfId;
    @FXML
    public TextField tfFname;
    @FXML
    public TextField tfLname;
    @FXML
    public TextField tfPhone;
    @FXML
    public TextField tfDeptID;
    @FXML
    public TextField tfNots;

    @FXML
    public TableColumn<CPatients , Integer> colId;
    @FXML
    public TableColumn<CPatients , String> colFname;
    @FXML
    public TableColumn<CPatients , String> colLname;
    @FXML
    public TableColumn<CPatients , String> colDeptName;

    public TableColumn<CPatients , Integer> colPhone;

    @FXML
    public TableColumn<CPatients , String> colNots;

    @FXML
    public TableView<CPatients> tvPat;



}