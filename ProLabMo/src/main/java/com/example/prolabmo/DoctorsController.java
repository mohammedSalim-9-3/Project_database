package com.example.prolabmo;

import CheakConnection.DBQuery;
import CheakConnection.cheakException;
import Clases.CDepartments;
import Clases.CDoctors;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorsController implements Initializable {

    @FXML
    private void Previous() throws IOException {
        ProjectDataBase.setRoot("Home");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showDectors();

    }

    private void showDectors()  {
        ObservableList<CDoctors> list = DBQuery.selectDoctors();
        colId.setCellValueFactory(new PropertyValueFactory<CDoctors , Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<CDoctors , String>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<CDoctors , Integer>("phone"));
        colDeptName.setCellValueFactory(new PropertyValueFactory<CDoctors , String>("dept_name"));
        tvDoc.setItems(list);
    }
    @FXML
    private void insertDoctor () {
         // Remember cheak dec not found -------- cheak dep found
        boolean cheak = DBQuery.searchDocId(Integer.parseInt(tfId.getText()));
        boolean cheakDept = DBQuery.SearchDepartment(Integer.parseInt(tfDeptID.getText()));
        boolean cheakDoc  = true;
        if (cheakDept == false) {
            cheakException.errorMessage();
        }else if (tfId.getText().length() > 6 || tfName.getText().length() > 10)
            cheakException.errorMessageValueBig();
        else if (cheak == true)
            cheakException.errorMessageIDDoc();
         else {

            DBQuery.insertDoctors(Integer.parseInt(tfId.getText()), tfName.getText() ,
                    Integer.parseInt(tfPhone.getText()) , Integer.parseInt(tfDeptID.getText()));
            showDectors();
        }
    }

    @FXML
    private void updateDoctor () {
        DBQuery.updateDoctor(Integer.parseInt(tfId.getText()) , tfName.getText() ,
                Integer.parseInt(tfPhone.getText()) , Integer.parseInt(tfDeptID.getText()));
        showDectors();
    }
    @FXML
    private void deleteDoctor () {
        DBQuery.deleteDoctor(Integer.parseInt(tfId.getText()));
        showDectors();
    }


    @FXML
    public TextField tfId;
    @FXML
    public TextField tfName;

    @FXML
    public TextField tfPhone;

    @FXML
    public TextField tfDeptID;



    public TableView<CDoctors> tvDoc;
    @FXML
    private TableColumn<CDoctors, Integer> colId;
    @FXML
    private TableColumn<CDoctors , String> colName;

    @FXML
    public TableColumn<CDoctors, Integer> colPhone;

    @FXML
    public TableColumn<CDoctors, String> colDeptName;
}