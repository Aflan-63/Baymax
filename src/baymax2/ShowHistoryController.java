/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import static baymax2.Baymax2.mainstage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USCHAS
 */
public class ShowHistoryController implements Initializable {

    @FXML
    Label patient, doctor;
    datrabase db = new datrabase();
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<patientHistory> tableview;
    @FXML
    private TableColumn<patientHistory, String> Name;
    @FXML
    private TableColumn<patientHistory, String> Date;
    @FXML
    private TableColumn<patientHistory, String> Consultant;
    private String doctorName, patientName;

    public void initData(String str, String str2) {
        doctorName = str;
        patientName = str2;
        doctor.setText(doctorName);
        patient.setText(patientName);

        //label.setText(patientUser);
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws Exception {
        System.out.println("yoooohhhhh");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("patientHome.fxml"));
        Scene scene = new Scene(pane);
        Stage window = new Stage();
        mainstage.setScene(scene);
        mainstage.show();
        System.out.println("You clicked me!");


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Name.setCellValueFactory(new PropertyValueFactory<patientHistory, String>("Name"));
        Date.setCellValueFactory(new PropertyValueFactory<patientHistory, String>("Date"));
        Consultant.setCellValueFactory(new PropertyValueFactory<patientHistory, String>("Consultant"));

        tableview.setItems(getPatient());
    }

    public ObservableList<patientHistory> getPatient() {

        ObservableList<patientHistory> ph = FXCollections.observableArrayList();
        //patientHistory p=new patientHistory("naa","kkk","lll");
        //ph.add(new patientHistory("naa","mahi","hi"));
        //ph.add(p);
        ArrayList<String> patient = new ArrayList<>();
        ArrayList<String> doc = new ArrayList<>();
        ArrayList<String> dt = new ArrayList<>();

        patient = db.meet_patient();
        doc = db.meet_doc();
        dt = db.meet_date();
        for (int i = 0; i < dt.size(); i++) {
            ph.add(new patientHistory(patient.get(i), dt.get(i), doc.get(i)));
        }

        return ph;

    }

}
