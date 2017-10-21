package exercicio2e3e4;

public class EnglishDateFormatter implements DateFormatter {

	@Override
	public String formatDate(Date date) {
		return ( date.get_Month() + "/" + date.get_Day() + "/" + date.get_Year() );
	}

}
