package exercicio1;

public class Address {
	String _Street;
	String _City;
	String _State;
	String _Zipcode;
	
	public Address(String street, String city, String state, String zipcode) {
		_Street = street;
		_City   = city;
		_State  = state;
		_Zipcode= zipcode;
	};
	
	public String toPrint() {
		return _Street + "\n" + _City +"\n" + _State + "\n" + _Zipcode + "\n";
	}
}
