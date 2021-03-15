package com.cg.apps.itemms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cg.apps.customerms.entity.Customer;

@Entity
public class Item {
	@Id
	private String id;

	private double price;
	private String description;
	private LocalDateTime addedDate;

	@ManyToOne
	private Customer boughtBy;

	public Item() {
	}

	public Item(String id, double price, String description) {
		this.setId(id);
		this.setPrice(price);
		this.setDesc(description);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public Customer getBoughtBy() {
		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {
		this.boughtBy = boughtBy;
	}

}
