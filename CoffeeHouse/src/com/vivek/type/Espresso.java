package com.vivek.type;
import com.vivek.decorator.Coffee;

public class Espresso extends Coffee {

	public Espresso() {
		super("Espresso");
	}

	@Override
	public double cost() {
		return 11;
	}

	@Override
	public String getDescription() {
		return super.getDescription() ;
	}
}
