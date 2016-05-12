/**
 * Class for unit converter object
 * @author Akarachai Passavoranan
 *
 */
public class UnitConverter {
	/**
	 * Constructor
	 * @param amount amount to convert
	 * @param fromUnit which unit to be converted
	 * @param toUnit which unit to convert to
	 * @return double a value of the converted value.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return amount*fromUnit.getValue()/toUnit.getValue();
	}
	/**
	 * return all length in Length class
	 * @return Unit[] All Units in a type(Length)
	 */
	public Unit[] getUnits() {
		return Length.values();
	}
}
