package com.cognizant.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menuitems")
public class MenuItem {
	@Id
	@Column(name = "menu_item_id")
	private int id;

	@Column(name = "menu_item_name")
	private String name;

	@Column(name = "menu_item_price")
	private float price;

	@Column(name = "menu_item_active")
	private boolean active;

	@Column(name = "menu_item_dateOfLaunch")
	private Date dateOfLaunch;

	@Column(name = "menu_item_category")
	private String category;

	@Column(name = "menu_item_freeDelivery")
	private boolean freeDelivery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public MenuItem(int id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		setId(id);
		setName(name);
		setPrice(price);
		setActive(active);
		setDateOfLaunch(dateOfLaunch);
		setCategory(category);
		setFreeDelivery(freeDelivery);
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public boolean equals(Object obj) {
		MenuItem other = (MenuItem) obj;
		return id == other.id;
	}

}
