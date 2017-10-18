package Excercicio2e3;

public class Address {
	String _Number;
	String _Street;
	String _City;
	String _State;
	String _Zipcode;
	
	
	private String _DisplayFormat;
	
	public Address(String street,String number, String city, String state, String zipcode) {
		_Street = street;
		_City   = city;
		_State  = state;
		_Zipcode= zipcode;
		_Number = number;
	};
	
	public String toPrint() {
		return _DisplayFormat;
	}

	public String get_Number() {
		return _Number;
	}

	public void set_Number(String _Number) {
		this._Number = _Number;
	}

	public String get_Street() {
		return _Street;
	}

	public void set_Street(String _Street) {
		this._Street = _Street;
	}

	public String get_City() {
		return _City;
	}

	public void set_City(String _City) {
		this._City = _City;
	}

	public String get_State() {
		return _State;
	}

	public void set_State(String _State) {
		this._State = _State;
	}

	public String get_Zipcode() {
		return _Zipcode;
	}

	public void set_Zipcode(String _Zipcode) {
		this._Zipcode = _Zipcode;
	}
	
	public void set_DisplayFormat(String _Display) {
		this._DisplayFormat = _Display;
	}
}
