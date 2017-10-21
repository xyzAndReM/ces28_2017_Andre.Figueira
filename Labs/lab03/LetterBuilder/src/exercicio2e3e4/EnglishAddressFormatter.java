package exercicio2e3e4;

public class EnglishAddressFormatter implements AddressFormatter {

	@Override
	public String formatAddress(Address add) {
		return ( add.get_Number() + " " + add.get_Street() + ",\nZip Code:" + add.get_Zipcode() + "\n" + add.get_City() + ", " + add.get_State()  + "\n");
	}

}
