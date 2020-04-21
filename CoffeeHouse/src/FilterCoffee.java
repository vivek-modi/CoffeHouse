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
		return coffee.description;
	}
}
