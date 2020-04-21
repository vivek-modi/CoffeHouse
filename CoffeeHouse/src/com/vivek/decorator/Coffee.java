package com.vivek.decorator;

public abstract class Coffee implements CoffeeInterface {

	protected String description;

	public Coffee(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public abstract double cost();
}
