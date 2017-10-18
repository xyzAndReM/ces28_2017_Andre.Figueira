package Excercicio2e3;

public class Date {
	int _Day;
	int _Month;
	int _Year;
	String _DisplayFormat;
	public Date(int day, int month, int year){
		_Day = day;
		_Month = month;
		_Year = year;
	}
	
	public String toPrint() {
		return _DisplayFormat;
	}

	public int get_Day() {
		return _Day;
	}

	public void set_Day(int _Day) {
		this._Day = _Day;
	}

	public int get_Month() {
		return _Month;
	}

	public void set_Month(int _Month) {
		this._Month = _Month;
	}

	public int get_Year() {
		return _Year;
	}

	public void set_Year(int _Year) {
		this._Year = _Year;
	}
	
	public void set_DisplayFormat(String _Display) {
		this._DisplayFormat = _Display;
	}
}
