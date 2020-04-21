package com.vivek.delivery;

import com.vivek.decorator.Coffee;
import com.vivek.decorator.Decorator;

public class InstantCoffee extends Decorator {

	public InstantCoffee(Coffee c) {
		super(c);
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + "\nPurchase: Instant";
	}

	@Override
	public double cost() {
		return 50 + coffee.cost();
	}
}
