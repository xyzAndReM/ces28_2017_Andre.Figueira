package lab02;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraString {
	static int add(String numbers) {
		String numbers2 = numbers;
		String separator = new String();
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(numbers);
		String pattern = "(\\\\)?(\\[(.*?)\\])*(\n)?(\\s+)*((-?\\d+)?((\\s)*,(\\s)*)*((\\s)*(\n)(\\s)*)*";
		while(m.find()) {
			separator = m.group(1);
			System.out.println(separator);
		    pattern += "((\\s)*" + separator + "(\\s)*)*";
		    numbers2 = numbers2.replaceAll(separator, ",");
		}
		pattern += ")*";
		
		
		//String pattern = "(\\s+)*((-?\\d+)?((\\s)*,(\\s)*)*((\\s)*\n(\\s)*)*)*";
		
		Pattern verificador = Pattern.compile(pattern);
		Matcher aceitavel = verificador.matcher(numbers);
		 if (!aceitavel.matches()) {
		        throw new IllegalArgumentException(pattern + "\n" + numbers2);
		 }
		
		LinkedList<String> numbers_list = new LinkedList<String>();
		String negatives_error = "[";
		p = Pattern.compile("-?\\d+");
		m = p.matcher(numbers2);
		int soma = 0,k = 0; String s;
		boolean negatives_exist = false;
		while (m.find()) {
			s = m.group();
			numbers_list.add(s);
			k = Integer.parseInt(m.group());
			if(k < 0) {
				k = 0;
				if(!negatives_exist) {
					negatives_exist = true;	
					negatives_error += s;
				}
				else {
					negatives_error += (" " + s);
				}
			}
			else if(k > 1000) {
				k = 0;
			}
			soma += k;
		}
		if(negatives_exist) {
			throw new NegativeNumbersException(negatives_error + "]");
		}
		return soma;
		
	}
}
