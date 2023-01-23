package com.example.prolabmo;

import CheakConnection.DBQuery;
import CheakConnection.cheakException;
import Clases.CPatients;
import Clases.CVisits;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class visitsController implements Initializable {

    @FXML
    private void Previous() throws IOException {
        ProjectDataBase.setRoot("Home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showVisits();
    }
    public void showVisits() {
        ObservableList<CVisits> list = DBQuery.selectVisits();
        colId.setCellValueFactory(new PropertyValueFactory<CVisits , Integer>("id"));
        colNameDoc.setCellValueFactory(new PropertyValueFactory<CVisits , String>("docName"));
        colNamePat.setCellValueFactory(new PropertyValueFactory<CVisits , String>("patName"));
        colMedRep.setCellValueFactory(new PropertyValueFactory<CVisits , String>("medReport"));
        tvVis.setItems(list);

    }
    @FXML
    public void insertVisit () {
        boolean cheakId = DBQuery.searchIDVisit(Integer.parseInt(tfId.getText()));
        boolean cheakIDDoc = DBQuery.searchDocId(Integer.parseInt(tfDocId.getText()));
        boolean cheakIDPat = DBQuery.searchPatId(Integer.parseInt(tfPatId.getText()));

        if (cheakId == true) {
            cheakException.errorMessageID();
        }else if (cheakIDDoc == false ) {
            cheakException.errorMessageDI();
        }else if (cheakIDPat == false) {
            cheakException.errorMessagePI();
            }
         else {
            DBQuery.insertVisits(Integer.parseInt(tfId.getText()), Integer.parseInt(tfDocId.getText()),
                    Integer.parseInt(tfPatId.getText()), tfMedRep.getText());
            showVisits();
        }
    }
  /* boolean cheak = DBQuery.SearchDepartment(Integer.parseInt(tfId.getText()));
        if (cheak == true) {
            cheakException.errorMessageID();*/
    @FXML
    public void updateVisit () {
        DBQuery.updateVisits(Integer.parseInt(tfId.getText()) , tfMedRep.getText());
        showVisits();
    }

    @FXML
    public void deleteVisit () {
        DBQuery.deleteVisits(Integer.parseInt(tfId.getText()));
        showVisits();
    }

    @FXML
    public TextField tfId;

    @FXML
    public TextField tfDocId;

    @FXML
    public TextField tfPatId;

    @FXML
    public TextField tfMedRep;

    @FXML
    public TableColumn<CVisits, Integer> colId;

    @FXML
    public TableColumn<CVisits , String> colNameDoc;

    @FXML
    public TableColumn<CVisits , String> colNamePat;

    @FXML
    public TableColumn<CVisits , String> colMedRep;

    @FXML
    public TableView<CVisits> tvVis;

}