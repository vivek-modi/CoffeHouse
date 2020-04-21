package com.vivek.addon;
import com.vivek.decorator.Coffee;
import com.vivek.decorator.Decorator;

public class Milk extends Decorator {

	public Milk(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return 4 + coffee.cost();
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + "\nExtra: Milk";
	}

}
