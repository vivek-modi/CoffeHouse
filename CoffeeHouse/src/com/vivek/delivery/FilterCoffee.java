package com.vivek.delivery;

import com.vivek.decorator.Coffee;
import com.vivek.decorator.Decorator;

public class FilterCoffee extends Decorator {

	public FilterCoffee(Coffee c) {
		super(c);
	}
	
	@Override
	public double cost() {
		return 80 + coffee.cost();
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + "\nPurchase: Filter";
	}
}
