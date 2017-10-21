package exercicio2e3e4;

public class Phone {
	int _DDD;
	String _Number;
	
	public Phone(int ddd, String number){
		_DDD = ddd;
		_Number = number;
	}
	
	public int get_DDD() {
		return _DDD;
	}
	public void set_DDD(int _DDD) {
		this._DDD = _DDD;
	}
	public String get_Number() {
		return _Number;
	}
	public void set_Number(String _Number) {
		this._Number = _Number;
	}
	
	
}
