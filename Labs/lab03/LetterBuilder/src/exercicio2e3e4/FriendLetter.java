package exercicio2e3e4;

public class FriendLetter extends LetterTemplate {
	
	
	public String Header() {
		String header = new String();
		header = _FieldFormatter.getFormattedAddress(_AddressSender) + _FieldFormatter.getFormattedAddress(_AddressDestinatary) + _FieldFormatter.getFormattedDate(_Date) + "\n\n\n";
		_Letter += header;
		return header;
	}

	public String Greetings() {
		String greetings = new String();
		greetings = _Greetings  + _Destinatary.first_name()+",\n\n";
		System.out.println(_Greetings);
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
		signature = "\t\t\t\t" + _Sender.first_name();
		_Letter += signature;
		return _Letter;
	}
	
}
