/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import static baymax2.Baymax2.mainstage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USCHAS
 */
public class PatientHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    ComboBox<String> comboDoc = new ComboBox<>();
    @FXML
    Label label;
    datrabase db = new datrabase();

    private String patientUser;

    public void initData(String str) {
        patientUser = str;
        label.setText(patientUser);
    }

    @FXML
    private void goButtonOnAction(ActionEvent event) throws Exception {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("showHistory.fxml"));
        loader.setLocation(getClass().getResource("showHistory.fxml"));
        ScrollPane pane = loader.load();
        Scene scene = new Scene(pane);
        ShowHistoryController controller = loader.getController();

        String doctorName, patientName;
        patientName = db.get_patient_name(label.getText());
        doctorName = comboDoc.getValue();
        controller.initData(doctorName, patientName);

        mainstage.setScene(scene);
        mainstage.show();


    }

    @FXML
    private void meetButtonOnAction(ActionEvent event) throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("patientMetDoc.fxml"));
        Scene scene = new Scene(pane);
        Stage window = new Stage();

        String doctorName, patientName, dt;
        patientName = db.get_patient_name(label.getText());
        doctorName = comboDoc.getValue();
        dt = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
        db.save_patient_doc(patientName, doctorName, dt);

        mainstage.setScene(scene);
        mainstage.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //comboDoc.getItems().addAll("Naila","Mahi","Raguib","Bananee","Siam");
        //datrabase db=new datrabase();
        ArrayList<String> doc = new ArrayList<>();
        doc = db.doc_load();
        for (int i = 0; i < doc.size(); i++) {
            comboDoc.getItems().addAll(doc.get(i));
            System.out.println(doc.get(i));

        }

    }

}
