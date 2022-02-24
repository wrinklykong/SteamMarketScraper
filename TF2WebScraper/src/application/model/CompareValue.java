//****************************************
//Class: 	CompareValue
//Purpose: 	Holds information relating to the
//			Fabricator and Kit price of the same
//			item. (It compares the two)
//
//****************************************

package application.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class CompareValue {
	
	// These are made as Properties to load into the Array Smoothly
	public SimpleStringProperty itemName = new SimpleStringProperty();					
	public SimpleDoubleProperty priceOfKit = new SimpleDoubleProperty();
	public SimpleDoubleProperty priceOfFabricator = new SimpleDoubleProperty();
	public SimpleDoubleProperty priceDifference = new SimpleDoubleProperty();
	
	public CompareValue() {
		
	}
	public CompareValue( String name, double pKit, double pFabricator, double pDiff ) {
		setItemName(name);
		setPriceOfKit(pKit);
		setPriceOfFabricator(pFabricator);
		setPriceDifference(pDiff);
	}
	
	public void setItemName( String a ) {
		this.itemNameProperty().set(a);
	}
	public void setPriceOfKit( double a ) {
		this.priceOfKitProperty().set(a);
	}
	public void setPriceOfFabricator( double a ) {
		this.priceOfFabricatorProperty().set(a);
	}
	
	public void setPriceDifference( double a ) {
		this.priceDifferenceProperty().set(a);
	}
	
	public String getItemName() {
		return this.itemName.get();
	}
	public double getPriceOfKit() {
		return this.priceOfKit.get();
	}
	public double getPriceOfFabricator() {
		return this.priceOfFabricator.get();
	}
	
	public double getPriceDifference() {
		return this.priceDifference.get();
	}

	public SimpleStringProperty itemNameProperty() {
		return this.itemName;
	}
	
	public DoubleProperty priceOfKitProperty() {
		return this.priceOfKit;
	}
	
	public DoubleProperty priceOfFabricatorProperty() {
		return this.priceOfFabricator;
	}
	
	public DoubleProperty priceDifferenceProperty() {
		return this.priceDifference;
	}
	
	@Override
	public String toString() {
		return "Item Name: " + getItemName() +". Kit Price: " + getPriceOfKit() + ". Price of Fab: " + getPriceOfFabricator() + ". Price Diff: " + getPriceDifference();
	}
	
}
