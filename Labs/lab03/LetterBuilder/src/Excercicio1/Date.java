package Excercicio1;

public class Date {
	int _Day;
	int _Month;
	int _Year;
	
	public Date(int day, int month, int year){
		_Day = day;
		_Month = month;
		_Year = year;
	}
	
	public String toPrint() {
		return _Day + "/" + _Month + "/" + _Year+"\n";
	}
}
