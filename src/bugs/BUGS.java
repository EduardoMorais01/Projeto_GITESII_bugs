/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 05220139
 */
public class BUGS extends Application {
  private HaveStage haveStage;

    @Override
    public void start(Stage stage) {
        this.haveStage = HaveStage.instance(stage);
        Parent root = null;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        } catch (IOException ex) {
        }

        scene = new Scene(root);

        haveStage.getStage().setScene(scene);
        haveStage.getStage().show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
