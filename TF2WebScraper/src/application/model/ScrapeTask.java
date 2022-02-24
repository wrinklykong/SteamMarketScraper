//****************************************
//Class: 	ScrapeTask
//Purpose: 	This class is used to run the main
//			chunk of code in a Thread so that
//			it does not freeze the application.
// Func.:	This class reads from the Steam API,
//			deserializes the information into Java
//			objects, and then exports the information
//			into a .csv file
//
//****************************************

package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import application.model.json.JsonResult;
import application.model.json.MarketplaceItem;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;

public class ScrapeTask implements Runnable {
	
	public SimpleDoubleProperty progressProperty = new SimpleDoubleProperty(0.1);

	@Override
	public void run() {
		ItemsContainer storage = new ItemsContainer();		// This will hold all of the CompareValues
		setProgressProperty(0.01);
		
		System.out.println("Thread begun.\nRunning ...");

    	// *********************************************
    	// In this section of code we will obtain the JSON
		// File that contains all of the PK Kits
    	//
    	// *********************************************
		
    	try {
    		String url = "";
    		URL web;
    		URLConnection request;
    		
    		// Convert to json?
    		JsonParser jp = new JsonParser();
    		JsonElement root;
    		
    		Gson gson = new Gson();
    		JsonResult results;
    		
    		setProgressProperty(0.1);
    		
    		for ( int i = 0; i < 2; i++ ) {
    			TimeUnit.SECONDS.sleep(5);
    			url = "https://steamcommunity.com/market/search/render/search?q=&category_440_Collection%5B%5D=any&category_440_Type%5B%5D=tag_TF_KillStreakifierToolC&category_440_Quality%5B%5D=tag_Unique&appid=440&norender=1&count=100&sort_column=name&sort_dir=asc";
    			url = url + "&start="+(i*100);
    			web = new URL(url);
    				
    			request = web.openConnection();
        		request.connect();
    			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
    			results = gson.fromJson(root, JsonResult.class);
    			for ( MarketplaceItem a : results.getResults() ) {
    				String price = a.getSell_price_text().substring(1);
    				price = price.replace(",", "");
    				CompareValue tmp = new CompareValue(a.getName(), Double.parseDouble(price),0,0);
        			storage.insertTo(false, tmp);
        		}
    			setProgressProperty(getProgressProperty()+0.0875);
    			System.out.println(storage.getProfessionalSpot());
    		}
    		
    		// We load the Specialized Killstreak kits in here now
    		
    		for ( int i = 0; i < 2; i++ ) {
    			TimeUnit.SECONDS.sleep(5);
    			url = "https://steamcommunity.com/market/search/render/search?q=&category_440_Collection%5B%5D=any&category_440_Type%5B%5D=tag_TF_KillStreakifierToolB&appid=440&norender=1&count=100&sort_column=name&sort_dir=asc";
    			if ( i == 1 )
    				url+="&start=100";
    			web = new URL(url);
    				
    			request = web.openConnection();
        		request.connect();
    			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
    			results = gson.fromJson(root, JsonResult.class);
    			for ( MarketplaceItem a : results.getResults() ) {
    				String price = a.getSell_price_text().substring(1);
    				price = price.replace(",", "");
    				CompareValue tmp = new CompareValue(a.getName(), Double.parseDouble(price),0,0);
        			storage.insertTo(true, tmp);
        		}
    			setProgressProperty(getProgressProperty()+0.0875);
    			System.out.println(storage.getSpecializedSpot());
    		}
    		
    		// Now we will obtain the JSON file for all of the Fabricators
    		for ( int i = 0; i < 4; i++ ) {
    			TimeUnit.SECONDS.sleep(5);
    			url = "https://steamcommunity.com/market/search/render/search?q=professional+killstreak+kit+fabricator&category_440_Collection%5B0%5D=any&category_440_Type%5B0%5D=tag_TF_ItemDynamicRecipeTool&appid=440&norender=1&count=100&sort_column=name&sort_dir=asc&start=";
    			if ( i == 0 )
    				url += "63";
    			else
    				url += i+"63";
    			web = new URL(url);
    				
    			request = web.openConnection();
        		request.connect();
    			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
    			results = gson.fromJson(root, JsonResult.class);
    			for ( MarketplaceItem a : results.getResults() ) {
    				if ( a.getName().contains("Professional") ) {
    					String name = a.getName().substring(0,a.getName().length()-11);
        				storage.updateFabricatorPrice(false, name, Double.parseDouble(a.getSell_price_text().substring(1)));
        			}
    				if ( a.getName().contains("Specialized") ) {
    					String name = a.getName().substring(0,a.getName().length()-11);
        				storage.updateFabricatorPrice(true, name, Double.parseDouble(a.getSell_price_text().substring(1)));
        			}
        		}
    			setProgressProperty(getProgressProperty()+0.0875);
    			System.out.println(storage.getNumProfFabricators());
    		}
    		
    	}
    	catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	
    	// ****************************************
    	// In this section of code, it will create
    	// a .csv file and paste the information into
    	// it.
    	// ****************************************
    	
    	CompareValue[] profList = storage.getProfList();
    	CompareValue[] specList = storage.getSpList();
    	
    	File csvFile = new File("data_"+CurrentDateAndTime.getCurrentDateAndTime()+".csv");
    	setProgressProperty(getProgressProperty()+0.05);
    	
    	try {
    		PrintWriter out = new PrintWriter(csvFile);
    		out.print("Item Name, Price of Fab., Price of Kit, Price Difference\n");
    		for ( CompareValue a : profList ) {
    			if ( a != null )
    				out.printf("%s, %.2f, %.2f, %.2f\n", a.getItemName(), a.getPriceOfFabricator(), a.getPriceOfKit(), a.getPriceDifference());
    		}
    		for ( CompareValue b : specList ) {
        		if ( b != null )
        			out.printf("%s, %.2f, %.2f, %.2f\n", b.getItemName(), b.getPriceOfFabricator(), b.getPriceOfKit(), b.getPriceDifference());
        	}
    		out.close();
    		setProgressProperty(getProgressProperty()+0.2);
    		System.out.println("Successfully created .csv file: "+csvFile.getName());
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }

	public double getProgressProperty() {
		return this.progressProperty.get();
	}
	
	public DoubleProperty progressProperty() {
		return this.progressProperty;
	}
	
	public void setProgressProperty(Double a) {
		this.progressProperty().set(a);
	}

}
