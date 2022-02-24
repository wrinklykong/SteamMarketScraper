//****************************************
//Class: 	AssetDescription
//Purpose: 	Used as a container for information
//			received from the Steam Market API.
//			This class contains item specific information
//			(differs from MarketplaceItem because this
//			information is unique to every instance
//			of the item being sold on the market)
//
//****************************************

package application.model.json;

import com.google.gson.annotations.SerializedName;

public class AssetDescription {
	
	@SerializedName("appid")
	private int appid;
	@SerializedName("classid")
	private String classid;
	@SerializedName("instanceid")
	private String instanceid;
	@SerializedName("icon_url")
	private String icon_url;
	@SerializedName("tradeable")
	private boolean tradeable;
	@SerializedName("name")
	private String name;
	@SerializedName("name_color")
	private String name_color;
	@SerializedName("type")
	private String type;
	@SerializedName("market_name")
	private String market_name;
	@SerializedName("market_hash_name")
	private String market_hash_name;
	@SerializedName("commodity")
	private boolean commodity;
	
	
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getInstanceid() {
		return instanceid;
	}
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	public boolean isTradeable() {
		return tradeable;
	}
	public void setTradeable(boolean tradeable) {
		this.tradeable = tradeable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_color() {
		return name_color;
	}
	public void setName_color(String name_color) {
		this.name_color = name_color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarket_name() {
		return market_name;
	}
	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}
	public String getMarket_hash_name() {
		return market_hash_name;
	}
	public void setMarket_hash_name(String market_hash_name) {
		this.market_hash_name = market_hash_name;
	}
	public boolean isCommodity() {
		return commodity;
	}
	public void setCommodity(boolean commodity) {
		this.commodity = commodity;
	}
	
}
