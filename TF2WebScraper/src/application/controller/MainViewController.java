//****************************************
//Class: 	MainViewController
//Purpose: 	Controls the Home screen.
//
//****************************************
package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainViewController {

    @FXML private Button tableButton;
    @FXML private Button generateButton;
    @FXML private AnchorPane mainpane;

    //Switches the fxml file to the GenerateView.fxml file
    @FXML void goToGenerateView(ActionEvent event) throws Exception {
    	URL url = new File("src/application/view/GenerateView.fxml").toURI().toURL();							
        mainpane = FXMLLoader.load(url);
        Scene scene = new Scene(mainpane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    //Switches the fxml file to the ItemListView.fxml file
    @FXML void goToTableView(ActionEvent event) throws Exception {
    	URL url = new File("src/application/view/ItemListView.fxml").toURI().toURL();							
        mainpane = FXMLLoader.load(url);
        Scene scene = new Scene(mainpane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}

