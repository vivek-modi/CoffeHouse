package com.vivek.type;
import com.vivek.decorator.Coffee;

public class Mochaccino extends Coffee {

	public Mochaccino() {
		super("Mochaccino");
	}

	@Override
	public double cost() {
		return 30;
	}

	@Override
	public String getDescription() {
		return super.getDescription();
	}
}
