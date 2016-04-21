
public class ConverterApp {
	public static void main(String[] args) {
		for (Length x: Length.values()) {
			System.out.println(x+" = "+x.getValue());
		}
		// test the convert method
		UnitConverter test = new UnitConverter();
		
		System.out.println(test.convert(5.0, Length.METER, Length.CENTIMETER));
	}
}
