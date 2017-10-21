package exercicio2e3e4;

public class PortugueseLetterFormatter extends LanguageFormatter {
	public PortugueseLetterFormatter() {
		AF = new PortugueseAddressFormatter();
		DF = new PortugueseDateFormatter();
		PF = new PortuguesePhoneFormatter();
		NF = new PortugueseNameFormatter();
	}
}
