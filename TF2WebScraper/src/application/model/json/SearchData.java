//****************************************
// Class: 	SearchData
// Purpose: Used as a container for information
// 			received from the Steam Market API.
//			This class contains information
//			relating to the response size, search
//			options, etc.
//
//****************************************

package application.model.json;

import com.google.gson.annotations.SerializedName;

public class SearchData {

	@SerializedName("query")
	private String query;
	@SerializedName("search_descriptions")
	private boolean search_descriptions;
	@SerializedName("total_coumt")
	private int total_count;
	@SerializedName("pagesize")
	private int pagesize;
	@SerializedName("prefix")
	private String prefix;
	@SerializedName("class_prefix")
	private String class_prefix;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public boolean isSearch_descriptions() {
		return search_descriptions;
	}
	public void setSearch_descriptions(boolean search_descriptions) {
		this.search_descriptions = search_descriptions;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getClass_prefix() {
		return class_prefix;
	}
	public void setClass_prefix(String class_prefix) {
		this.class_prefix = class_prefix;
	}
	
}
