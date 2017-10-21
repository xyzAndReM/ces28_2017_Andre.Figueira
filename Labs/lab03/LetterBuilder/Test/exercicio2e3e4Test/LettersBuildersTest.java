package exercicio2e3e4Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio2e3e4.Address;
import exercicio2e3e4.AddressFormatter;
import exercicio2e3e4.AnonymousLetter;
import exercicio2e3e4.BusinessLetter;
import exercicio2e3e4.Date;
import exercicio2e3e4.Director;
import exercicio2e3e4.EnglishLetterFormatter;
import exercicio2e3e4.FriendLetter;
import exercicio2e3e4.LanguageFormatter;
import exercicio2e3e4.LetterTemplate;
import exercicio2e3e4.Person;
import exercicio2e3e4.Phone;
import exercicio2e3e4.PortugueseAddressFormatter;
import exercicio2e3e4.PortugueseLetterFormatter;

public class LettersBuildersTest {
	
	Address address_destinatary;
	String street_destinatary = "Spencer Mansion";
	String number_destinatary = "747";
	String city_destinatary   = "Racoon City";
	String state_destinatary = "Kentucky";
	String zipcode_destinatary = "1914";
	
	Address address_sender;
	String street_sender = "Hospital";
	String number_sender = "99";
	String city_sender   = "Silent Hill";
	String state_sender = "Maine";
	String zipcode_sender = "1918";
	
	Person person_destinatary;
	String firstname_destinatary = "Albert";
	String lastname_destinatary = "Wesker";
	String gender_destinatary = "Male";
	String title_destinatary = "Umbrella Scientist";
	Phone phone_destinatary = new Phone(55,"555-6767");
	String email_destinatary = "wesker@umbrella.us";
	
	Person person_sender;
	String firstname_sender = "Harry";
	String lastname_sender = "Mason";
	String gender_sender = "Male";
	String title_sender = "Writer";
	Phone phone_sender = new Phone(55,"555-9999");
	String email_sender = "hmason@gmail.com"; 
	
	Date date;
	int day   = 28;
	int month = 6;
	int year  = 1914;
	
	LanguageFormatter Eformatter;
	LanguageFormatter Pformatter;
	Director diretor;
	LetterTemplate friendletter;
	LetterTemplate businessletter;
	LetterTemplate anonymousletter;
	
	@Before
	public void setUp(){
		address_destinatary = new Address(street_destinatary,number_destinatary,city_destinatary,state_destinatary,zipcode_destinatary);
		address_sender = new Address(street_sender,number_sender,city_sender,state_sender,zipcode_sender);
		person_destinatary = new Person(firstname_destinatary,lastname_destinatary,gender_destinatary,title_destinatary,phone_destinatary,email_destinatary);
		person_sender = new Person(firstname_sender,lastname_sender,gender_sender,title_sender,phone_sender,email_sender);
		date = new Date(day,month,year);
		
		/*
		 * O director recebe dois argumentos principais: o modelo da carta a ser cosntruída e o formatador em sua respectiva língua. Além
		 * disto ele também precisa dos dados para preencher os respectivos campos. Em resumo, o diretor é o responsável por receber os 
		 * argumentos e construir a carta no final.
		 */
		diretor = new Director();
		/*
		 * Formatadores de língua
		 */
		Eformatter = new EnglishLetterFormatter(); // Instanciando os formatores de língua
		Pformatter = new PortugueseLetterFormatter(); // Instanciando os formatores de língua
		/*
		 * Modelos de cartas
		 */
		friendletter = new FriendLetter();
		businessletter = new BusinessLetter();
		anonymousletter = new AnonymousLetter();
		
		diretor.setLetterDate(date);
		diretor.setLetterDestinatary(person_destinatary);
		diretor.setLetterDestinataryAddress(address_destinatary);
		diretor.setLetterSender(person_sender);
		diretor.setLetterSenderAddress(address_sender);
		
}
	
/**
 * Exercício 2 e 3	
 */
	@Test
	public void FriendLetterInEnglish() {
		diretor.setLetterBuilder(friendletter);
		diretor.setLanguage(Eformatter);
		diretor.constructLetter();
		assertEquals("99 Hospital,\nZip Code:1918\nSilent Hill, Maine\n747 Spencer Mansion,\nZip Code:1914\nRacoon City, Kentucky\n6/28/1914\n\n\nAlbert,\n\n"
				+ "<>\n\n" + ",\n" + "\t\t\t\tHarry",diretor.getLetter());
	}
	
	@Test
	public void BusinessLetterInEnglish() {
		diretor.setLetterBuilder(businessletter);
		diretor.setLanguage(Eformatter);
		diretor.constructLetter();
		assertEquals("99 Hospital,\n" + 
				"Zip Code:1918\n" + 
				"Silent Hill, Maine\n" + 
				"747 Spencer Mansion,\n" + 
				"Zip Code:1914\n" + 
				"Racoon City, Kentucky\n" + 
				"6/28/1914\n" + 
				"\n" + 
				"\n" + 
				" Mr Wesker,\n" + 
				"\n" + 
				"<>\n" + 
				"\n" + 
				",\n" + 
				"				Harry Mason\n" + 
				"				Writer\n" + 
			    "				55 555-9999\n" + 
			    "				hmason@gmail.com",diretor.getLetter());
	}

	@Test
	public void FriendLetterInPortuguese() {
		diretor.setLetterBuilder(friendletter);
		diretor.setLanguage(Pformatter);
		diretor.constructLetter();
		assertEquals("Hospital, n° 99\n" + 
				"Silent Hill, Maine\n" + 
				"1918\n" + 
				"Spencer Mansion, n° 747\n" + 
				"Racoon City, Kentucky\n" + 
				"1914\n" + 
				"28/6/1914\n" + 
				"\n" + 
				"\n" + 
				"Albert,\n" + 
				"\n" + 
				"<>\n" + 
				"\n" + 
				",\n" + 
				"				Harry",diretor.getLetter());
		
	}
	
	@Test
	public void AnonymousLetterInPortuguese() {
		diretor.setLetterBuilder(anonymousletter);
		diretor.setLanguage(Pformatter);
		diretor.constructLetter();
		assertEquals(" Senhor Wesker,\n\n",diretor.getLetter());
	}
	
	/**
	 * Exercicio 4
	 */
	@Test
	public void ChangeFormationModeOfLanguage() {
		diretor.setLetterBuilder(friendletter); //Escolhendo o formato da carta
		AddressFormatter new_formatter = new PortugueseAddressFormatter(); //Aqui eu estou reaproveitando um formato de endereço diferente do ingles, mas poderia ser
		//qualquer construido pelo programador
		Eformatter.setAddressFormatter(new_formatter); //mudando o formato de endereço padrao do ingles para o novo formato
		diretor.setLanguage(Eformatter);
		diretor.constructLetter();
		assertEquals("Hospital, n° 99\n" + 
				"Silent Hill, Maine\n" + 
				"1918\n" + 
				"Spencer Mansion, n° 747\n" + 
				"Racoon City, Kentucky\n" + 
				"1914\n" + 
				"6/28/1914\n" + 
				"\n" + 
				"\n" + 
				"Albert,\n" + 
				"\n" + 
				"<>\n" + 
				"\n" + 
				",\n" + 
				"				Harry",diretor.getLetter());
	}//Perceba que aqui o formato do endereço esta em portugues enquanto o formato da data esta em inglês.
	
	
}
