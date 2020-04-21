
public class InstantCoffee extends Decorator {

	public InstantCoffee(Coffee c) {
		super(c);
	}

	@Override
	public String getDescription() {
		return coffee.description;
	}

	@Override
	public double cost() {
		return 50 + coffee.cost();
	}
}
