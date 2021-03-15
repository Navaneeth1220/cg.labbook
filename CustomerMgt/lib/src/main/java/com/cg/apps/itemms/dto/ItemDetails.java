package com.cg.apps.itemms.dto;

public class ItemDetails {
	private String itemId;
	private double price;
	private String description;
	
	public ItemDetails() {}
	
	public ItemDetails(String itemId,double price,String description) {
		this.itemId=itemId;
		this.price=price;
		this.description=description;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
