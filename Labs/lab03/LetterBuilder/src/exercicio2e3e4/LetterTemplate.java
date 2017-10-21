package exercicio2e3e4;

public abstract class LetterTemplate {
	
	Person _Sender;
	Person _Destinatary;
	Address _AddressSender;
	Address _AddressDestinatary;
	Date _Date;
	String _Letter = "";
	String _Greetings = "";
	String _Conclusion = "";
	String _Body = "<>";
	LanguageFormatter _FieldFormatter;
	
	
	public abstract String Header();
	
	public abstract String Greetings();
 	
	public abstract String Body() ;
 	
	public abstract String Conclusion();
 	
	public abstract String Signature() ;
 	
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
	public void setLanguage(LanguageFormatter LAF) {
		_FieldFormatter = LAF;
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
