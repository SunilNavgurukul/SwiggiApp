package com.sunil;

import java.util.Arrays;

public class Restaurant {

	private int id;
	private Item[] items;
	private String name;
	private double revenue;
	private double expense;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}


	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", items=" + Arrays.toString(items) + ", name=" + name + ", revenue=" + revenue
				+ ", expense=" + expense + "]";
	}
	
	
	
	
}
