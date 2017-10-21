package exercicio2e3e4;

public class PortuguesePhoneFormatter implements PhoneFormatter {
	public String formatPhone(Phone phone) {
		return ("(" + phone.get_DDD() + ")" + " " + phone.get_Number() );
	}

}
