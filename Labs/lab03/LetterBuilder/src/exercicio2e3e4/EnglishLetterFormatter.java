package exercicio2e3e4;

public class EnglishLetterFormatter extends LanguageFormatter {
	
	public EnglishLetterFormatter() {
		AF = new EnglishAddressFormatter();
		DF = new EnglishDateFormatter();
		PF = new EnglishPhoneFormatter();
		NF = new EnglishNameFormatter();
	}
}
