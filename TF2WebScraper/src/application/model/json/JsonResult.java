//****************************************
//Class: 	JsonResult
//Purpose: 	Used as a container for information
//			received from the Steam Market API.
//			This class contains all of the information
//			that is received from the JSON result
//			sent from the Steam API.
//
//****************************************
package application.model.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class JsonResult {

	@SerializedName("success")
	private boolean success;
	@SerializedName("start")
	private int start;
	@SerializedName("pagesize")
	private int pagesize;
	@SerializedName("total_count")
	private int total_count;
	@SerializedName("searchdata")
	private SearchData searchdata;
	@SerializedName("results")
	private List<MarketplaceItem> results;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public SearchData getSearchdata() {
		return searchdata;
	}
	public void setSearchdata(SearchData searchdata) {
		this.searchdata = searchdata;
	}
	public List<MarketplaceItem> getResults() {
		return results;
	}
	public void setResults(List<MarketplaceItem> results) {
		this.results = results;
	}
	
}
