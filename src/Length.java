
public enum Length {
	METER("Meter", 1.00),
	KILOMETER("Kilometer", 1000.0),
	MILE("Mile", 1609.344),
	FOOT("Foot", 0.30480),
	WA("Wa", 2.0),
	CENTIMETER("Centimeter", 0.01);
	
	private final String name;
	private final double value;
	
	private Length(String name, double value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return this.name;
	}
	public double getValue() {
		return value;
	}
}
