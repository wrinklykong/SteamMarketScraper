//****************************************
//Class: 	ItemListController
//Purpose: 	Controls the ItemList view and loads
//			information from csv into table.
//
//****************************************

package application.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.model.CompareValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ItemListViewController {
	@FXML private Button fileUploadButton;
	@FXML private TableView<CompareValue> infoTable;
	@FXML private AnchorPane mainPane;
	@FXML private Button homeButton;
    @FXML private TableColumn<CompareValue, Double> kitCostCol;
    @FXML private TableColumn<CompareValue, String> itemNameCol;
    @FXML private TableColumn<CompareValue, Double> fabCostCol;
    @FXML private TableColumn<CompareValue, Double> diffCol;
    
	@FXML
	void loadFile(ActionEvent event) throws Exception {							// Loads csv file that is inputted from user input
		
		FileChooser fc = new FileChooser();
		File selFile = fc.showOpenDialog(null);
		Scanner f = new Scanner("");
		ObservableList<CompareValue> formatted = FXCollections.observableArrayList();
		
		itemNameCol.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());						// Not sure why this one is in lambda!
		fabCostCol.setCellValueFactory(new PropertyValueFactory<CompareValue, Double>("priceOfFabricator"));		// These three lines connect the values in CompareValue to their
		kitCostCol.setCellValueFactory(new PropertyValueFactory<CompareValue, Double>("priceOfKit"));				// respected columns :)
		diffCol.setCellValueFactory(new PropertyValueFactory<CompareValue, Double>("priceDifference"));
		
		if ( selFile != null ) {
			f = new Scanner(selFile);
			f.nextLine();											// Skips over the first line since its not of any use
			String curLine = "";
			String[] split;
			while ( f.hasNextLine() ) {
				curLine = f.nextLine();
				split = curLine.split(",");
				formatted.add(new CompareValue(split[0], Double.parseDouble(split[2]), Double.parseDouble(split[1]), Double.parseDouble(split[3])));
			}
			infoTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			infoTable.setItems(formatted);												// Loads CompareValue info into the table
		}
		else {
			System.out.println("File is not valid");
		}
	}
	
	@FXML
	void goToHomePage(ActionEvent event) throws Exception {
		URL url = new File("src/application/view/HomeView.fxml").toURI().toURL(); 		// Switches the fxml file to the Home.fxml
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

}
