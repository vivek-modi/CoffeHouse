package com.vivek.decorator;

public abstract class Decorator extends Coffee {

	protected Coffee coffee;

	public Decorator(Coffee coffee) {
		super(coffee.description);
		this.coffee = coffee;
	}

}
