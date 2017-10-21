package exercicio2e3e4;

public class PortugueseDateFormatter implements DateFormatter {
	public String formatDate(Date date) {
		return(date.get_Day() + "/" + date.get_Month() + "/" +date.get_Year());
	}
}
