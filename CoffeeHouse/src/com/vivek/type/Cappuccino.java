package com.vivek.type;

import com.vivek.decorator.Coffee;

public class Cappuccino extends Coffee {

	public Cappuccino() {
		super("Cappuccino");
	}

	@Override
	public String getDescription() {
		return super.getDescription();
	}

	@Override
	public double cost() {
		return 10;
	}
}
