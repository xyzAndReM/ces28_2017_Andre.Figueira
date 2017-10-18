package Excercicio2e3;

public class FriendLetter implements LetterBuilder {
	
	Person _Sender;
	Person _Destinatary;
	Address _AddressSender;
	Address _AddressDestinatary;
	Date _Date;
	String _Letter = "";
	String _Greetings = new String();
	String _Conclusion = new String();
	String _Body = new String();
	
	
	public String Header() {
		String header = new String();
		header = _AddressSender.toPrint() + _AddressDestinatary.toPrint() + _Date.toPrint() + "\n\n\n";
		_Letter += header;
		return header;
	}

	public String Greetings() {
		String greetings = new String();
		greetings = _Greetings + " " + _Destinatary.first_name()+",\n\n";
		System.out.println(_Greetings);
		_Letter += greetings;
		return greetings;
	}

	public String Body() {
		String body = new String();
		body = "<" + _Body + ">\n\n";
		_Letter += body;
		return body;
	}

	public String Conclusion() {
		String conclusion = new String();
		conclusion = _Conclusion + ",\n";
		_Letter += conclusion;
		return conclusion;
	}

	public String Signature() {
		String signature = new String();
		signature = "\t\t\t\t" + _Sender.first_name();
		_Letter += signature;
		return _Letter;
	}
	
	public String model() {
		return _Letter;
	}
	
	public void setSender(Person sender) {
		_Sender = sender;
	}
	public void setDestinatary(Person destinatary) {
		_Destinatary = destinatary;
	}
	public void setSenderAddress(Address addressSender) {
		_AddressSender = addressSender;
	}
	public void setDestinataryAddress(Address addressDestiny) {
		_AddressDestinatary = addressDestiny;
	}
	public void setDate(Date date) {
		_Date = date;
	}
	public void setGreetings(String _Greetings) {
		this._Greetings = _Greetings;
	}
	public void setBody(String _Body) {
		this._Body = _Body;
	}
	public void setConclusion(String Conclusion) {
		this._Conclusion = Conclusion;
	}
}
