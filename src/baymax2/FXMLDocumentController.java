/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import static baymax2.Baymax2.mainstage;
import static baymax2.Baymax2.pubScene;

/**
 * @author USCHAS
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelBayMax;

    @FXML
    private void openButtonOnAction(ActionEvent event) throws Exception {
        System.out.println("yoooo");
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
    }

}
