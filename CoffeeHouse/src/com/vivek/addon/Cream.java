package com.vivek.addon;
import com.vivek.decorator.Coffee;
import com.vivek.decorator.Decorator;

public class Cream extends Decorator {

	public Cream(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return 5 + coffee.cost();
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + "\nExtra: Cream";
	}
}
