/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import static baymax2.Baymax2.mainstage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USCHAS
 */

public class LoginController implements Initializable {

    @FXML
    Button logInButton, signUpButton;
    @FXML
    TextField t1, t2;
    @FXML
    Label label;
    datrabase db = new datrabase();

    @FXML
    private void signUpButtonOnAction(ActionEvent event) throws Exception {
        System.out.println("yoooohhhhh");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(pane);
        Stage window = new Stage();
        mainstage.setScene(scene);
        mainstage.show();
        System.out.println("You clicked me!");


    }

    @FXML
    private void logInButtonOnAction(ActionEvent event) throws Exception {

        String username, password;
        int c;
        username = t1.getText();
        password = t2.getText();

        c = db.check_info(username, password);
        if (c == 0) label.setText("Invalid Login  Credential");
        else {

//          AnchorPane pane = FXMLLoader.load(getClass().getResource("patientHome.fxml"));
//          Scene scene= new Scene(pane);
//          Stage window = new Stage();
//          mainstage.setScene(scene);
//          mainstage.show();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("patientHome.fxml"));
            loader.setLocation(getClass().getResource("patientHome.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            PatientHomeController controller = loader.getController();
            controller.initData(username);

            mainstage.setScene(scene);
            mainstage.show();


        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setText(" ");
    }

}
