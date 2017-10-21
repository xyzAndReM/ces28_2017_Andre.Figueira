package exercicio2e3e4;

public class BusinessLetter extends LetterTemplate {

	public String Header() {
		String header = new String();
		header = _FieldFormatter.getFormattedAddress(_AddressSender) + _FieldFormatter.getFormattedAddress(_AddressDestinatary) + _FieldFormatter.getFormattedDate(_Date) + "\n\n\n";
		_Letter += header;
		return header;
	}

	public String Greetings() {
		String greetings = new String();
		greetings = _Greetings  + " " + _FieldFormatter.getFormattedName(_Destinatary)+",\n\n";
		_Letter += greetings;
		return greetings;
	}

	public String Body() {
		String body = new String();
		body = "" + _Body + "\n\n";
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
		signature = "\t\t\t\t" + _Sender._FirstName+" "+ _Sender._LastName + "\n\t\t\t\t"+_Sender.title() + "\n\t\t\t\t"+_FieldFormatter.getFormattedPhone(_Sender.phone_number()) + "\n\t\t\t\t"+
		_Sender.email();
		_Letter += signature;
		return _Letter;
	}

}
