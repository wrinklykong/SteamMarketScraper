//****************************************
//Class: 	MarketplaceItem
//Purpose: 	Used as a container for information
//			received from the Steam Market API.
//			This class contains information relating
//			to the items listed on the Market.
//
//****************************************
package application.model.json;

import com.google.gson.annotations.SerializedName;

public class MarketplaceItem {

	@SerializedName("name")
	private String name;
	@SerializedName("hash_name")
	private String hash_name;
	@SerializedName("sell_listings")
	private int sell_listings;
	@SerializedName("sell_price")
	private int sell_price;
	@SerializedName("sell_price_text")
	private String sell_price_text;
	@SerializedName("app_icon")
	private String app_icon;
	@SerializedName("app_name")
	private String app_name;
	@SerializedName("asset_descriptiom")
	private AssetDescription asset_description;
	@SerializedName("sale_price_text")
	private String sale_price_text;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHash_name() {
		return hash_name;
	}
	public void setHash_name(String hash_name) {
		this.hash_name = hash_name;
	}
	public int getSell_listings() {
		return sell_listings;
	}
	public void setSell_listings(int sell_listings) {
		this.sell_listings = sell_listings;
	}
	public int getSell_price() {
		return sell_price;
	}
	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}
	public String getSell_price_text() {
		return sell_price_text;
	}
	public void setSell_price_text(String sell_price_text) {
		this.sell_price_text = sell_price_text;
	}
	public String getApp_icon() {
		return app_icon;
	}
	public void setApp_icon(String app_icon) {
		this.app_icon = app_icon;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public AssetDescription getAsset_description() {
		return asset_description;
	}
	public void setAsset_description(AssetDescription asset_description) {
		this.asset_description = asset_description;
	}
	public String getSale_price_text() {
		return sale_price_text;
	}
	public void setSale_price_text(String sale_price_text) {
		this.sale_price_text = sale_price_text;
	}
	
	
}
