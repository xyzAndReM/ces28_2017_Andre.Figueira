package exercicio2e3e4;

public class PortugueseAddressFormatter implements AddressFormatter {
	public String formatAddress(Address add) {
		return (add.get_Street() + ", n° " + add.get_Number()+"\n"+add.get_City()+", "+add.get_State()+"\n"+add.get_Zipcode()+"\n");
	}
}
