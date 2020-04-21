package com.vivek.addon;
import com.vivek.decorator.Coffee;
import com.vivek.decorator.Decorator;

public class Caramel extends Decorator {

	public Caramel(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return 6 + coffee.cost();
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\nExtra: Caramel";
	}
}
