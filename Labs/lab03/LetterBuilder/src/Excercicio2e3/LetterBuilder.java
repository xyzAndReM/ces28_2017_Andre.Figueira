package Excercicio2e3;

public interface LetterBuilder {
	public String Header();
	
 	public String Greetings();
 	
 	public String Body() ;
 	
 	public String Conclusion();
 	
 	public String Signature() ;
 	
 	public String model() ;
 	
 	public void setSender(Person sender);
 	
	public void setDestinatary(Person destinatary);
	
	public void setSenderAddress(Address addressSender);
	
	public void setDestinataryAddress(Address addressDestiny);
	
	public void setDate(Date date);
	
	public void setGreetings(String greetings);
	
	public void setBody(String body);

	public void setConclusion(String conclusion);
}
