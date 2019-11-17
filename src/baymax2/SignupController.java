/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import static baymax2.Baymax2.mainstage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USCHAS
 */
public class SignupController implements Initializable {

    /**
     * Initializes the controller class.
     */


    @FXML
    ComboBox<String> comboSex = new ComboBox<>();
    @FXML
    ComboBox<Integer> comboDate = new ComboBox<>();
    @FXML
    ComboBox<String> comboMonth = new ComboBox<>();
    @FXML
    ComboBox<Integer> comboYear = new ComboBox<>();
    @FXML
    TextField t1, t2, t3, t4, t5, t6, t7, t8;
    @FXML
    Label label;
    datrabase db = new datrabase();
    int c;

    @FXML
    private void signUpButtonOnAction(ActionEvent event) throws Exception {

        String firstname, lastname, mobileno, age, sex, height, weight, username, password;
        firstname = t1.getText();
        lastname = t2.getText();
        mobileno = t3.getText();
        age = t4.getText();
        height = t5.getText();
        weight = t6.getText();
        sex = comboSex.getValue();
        username = t7.getText();
        password = t8.getText();
        Statement statement = null;
        Connection connection = null;
        try {
            connection = datrabase.getConnection();
            statement = connection.createStatement();
            c = db.save_patient_info(firstname, lastname, mobileno, sex, age, height, weight, username, password);

            if (connection != null) {
                System.out.println("Connection Established!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


        if (c == 0) label.setText("USERNAME NOT AVAILABLE");
        else {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("SuccessfulSignUp.fxml"));
            Scene scene = new Scene(pane);
            Stage window = new Stage();
            mainstage.setScene(scene);
            mainstage.show();
        }


    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(pane);
        Stage window = new Stage();
        mainstage.setScene(scene);
        mainstage.show();
        System.out.println("You clicked me!");


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboSex.getItems().addAll("Male", "Female");
        for (int i = 1; i <= 31; i++) comboDate.getItems().addAll(i);
        comboMonth.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        for (int i = 1990; i <= 2017; i++) comboYear.getItems().addAll(i);
        label.setText(" ");

    }

}
