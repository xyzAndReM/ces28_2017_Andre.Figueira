package lab02;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraString {
	static int add(String numbers) {
		String numbers2 = numbers;
		String separator = new String();
		Pattern p = Pattern.compile("\\[(.*?)\\]"); //Ler todos as strings dentro de  colchetes
		Matcher m = p.matcher(numbers);
		String pattern = "(\\\\)?(\\[(.*?)\\])*(\n)?(\\s+)*((-?\\d+)?((\\s)*,(\\s)*)*((\\s)*(\n)(\\s)*)*"; //Patter default que considera
		// como separador a , e o \n. Além disto, ignora todos os espaços entre os separadores.
		while(m.find()) {
			separator ="\\Q" +  m.group(1) + "\\E"; //O \Q e o \E servem para ler a expressao literalmente, evitando que elementos pre definidos
			// no regex causem problemas, ex: *.
		    pattern += "((\\s)*" + separator + "(\\s)*)*"; // adicionando ao patter default o novo separador
		    numbers2 = numbers2.replaceAll(separator, ","); // trocando todos os separadores novos na string pelo separador
		    // default , . Isto ajuda no caso do símbolo -
		}
		pattern += ")*";
		
		Pattern verificador = Pattern.compile(pattern);
		System.out.println(verificador);
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
