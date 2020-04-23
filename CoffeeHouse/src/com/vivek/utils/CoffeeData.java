package com.vivek.utils;

import java.util.ArrayList;

public class CoffeeData {
	private double cost;
	private String extras;

	public CoffeeData(String extras, double cost) {
		this.cost = cost;
		this.extras = extras;
	}

	public CoffeeData() {

	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

}
