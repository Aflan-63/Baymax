/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author USCHAS
 */
public class Baymax2 extends Application {
    public static Stage mainstage;
    public static Scene pubScene;
    datrabase db = new datrabase();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = datrabase.getConnection();
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
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main_cover.fxml"));
        Scene scene = new Scene(root);
        pubScene = scene;
        mainstage = stage;
        mainstage.setScene(pubScene);
        mainstage.show();
    }

}
