//****************************************
//Class: 	GenerateViewController
//Purpose: 	Controls the JavaFX elements of the Generate
//			screen. Begins the ScrapeTask thread.
//
//****************************************
package application.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.ScrapeTask;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class GenerateViewController implements Initializable {
    @FXML private TextField URLInput;
    @FXML private ProgressBar progBar;
    @FXML private Button homeButton;
    @FXML private AnchorPane mainPane;
    
    double percentageDone;
    
    @FXML
    void grabHTML(ActionEvent event) {								// Initializes the ScrapeTask
    	progBar.setVisible(true);
    	
    	ScrapeTask p=new ScrapeTask();
    	
		progBar.progressProperty().unbind();						// Binds to progressProperty to display
		progBar.progressProperty().bind(p.progressProperty());		// progress of thread (sort of poorly)
		
		Thread t1=new Thread(p);
		t1.start();
    }
    
    @FXML
    void updateProgress() {
    	progBar.setProgress(percentageDone);
    }

    void setPercentageDone(double a) {
    	this.percentageDone = a;
    }

    @FXML
    void goToHomePage(ActionEvent event) throws Exception {						
    	URL url = new File("src/application/view/HomeView.fxml").toURI().toURL();							//Switches the fxml file to the HomeView.fxml file
        mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progBar.setVisible(false);
	}
    
}