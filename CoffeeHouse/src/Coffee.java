
public abstract class Coffee {

	private String description;

	public Coffee(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
