package exercicio2e3e4;

public class AnonymousLetter extends LetterTemplate {

	@Override
	public String Header() {
		return null;
	}

	@Override
	public String Greetings() {
			String greetings = new String();
			String pronoun = new String();
			if(_Destinatary.gender() == "Male") {
				pronoun = "Mr";
			}
			else {
				pronoun = "Ms";
			}
			greetings = _Greetings  +pronoun + " " + _Destinatary.last_name()+",\n\n";
			_Letter += greetings;
			return greetings;
	}

	@Override
	public String Body() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Conclusion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Signature() {
		// TODO Auto-generated method stub
		return null;
	}

}
