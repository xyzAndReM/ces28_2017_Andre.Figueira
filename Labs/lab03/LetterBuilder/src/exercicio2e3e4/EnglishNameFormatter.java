package exercicio2e3e4;

public class EnglishNameFormatter implements NameFormatter {

	
		public String formatName(Person person) {
			return ( genderPronoun(person) + " " +  person.last_name() );
		}
		
		public String genderPronoun(Person person) {
			if(person.gender() == "Male") {
				return "Mr";
			}
			else {
				return ("Ms");
			}
		}
}
