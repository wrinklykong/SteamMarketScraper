//****************************************
//Class: 	Main
//Purpose: 	Initializes JavaFX elements.
//
//****************************************

package application;
	
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import application.model.CompareValue;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/view/HomeView.fxml").toURI().toURL();
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
