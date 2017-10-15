package Exercicio1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Excercicio1.Address;
import Excercicio1.Date;
import Excercicio1.Formatter;
import Excercicio1.FriendLetter;
import Excercicio1.LetterBuilder;
import Excercicio1.Person;

public class LettersBuildersTest {
	
	Address address_destinatary;
	String street_destinatary = "Spencer Mansion";
	String city_destinatary   = "Racoon City";
	String state_destinatary = "Kentucky";
	String zipcode_destinatary = "1914";
	
	Address address_sender;
	String street_sender = "Hospital";
	String city_sender   = "Silent Hill";
	String state_sender = "Maine";
	String zipcode_sender = "1918";
	
	Person person_destinatary;
	String firstname_destinatary = "Albert";
	String lastname_destinatary = "Wesker";
	String gender_destinatary = "Male";
	String title_destinatary = "Umbrella Scientist";
	String phone_destinatary = "555-6767";
	String email_destinatary = "wesker@umbrella.us";
	
	Person person_sender;
	String firstname_sender = "Harry";
	String lastname_sender = "Mason";
	String gender_sender = "Male";
	String title_sender = "Writer";
	String phone_sender = "555-9999";
	String email_sender = "hmason@gmail.com"; 
	
	Date date;
	int day   = 28;
	int month = 6;
	int year  = 1914;
	
	Formatter formatter;
	LetterBuilder friendletter;
	
	@Before
	public void setUp(){
		address_destinatary = new Address(street_destinatary,city_destinatary,state_destinatary,zipcode_destinatary);
		address_sender = new Address(street_sender,city_sender,state_sender,zipcode_sender);
		person_destinatary = new Person(firstname_destinatary,lastname_destinatary,gender_destinatary,title_destinatary,phone_destinatary,email_destinatary);
		person_sender = new Person(firstname_sender,lastname_sender,gender_sender,title_sender,phone_sender,email_sender);
		date = new Date(day,month,year);
		formatter = new Formatter();
		friendletter = new FriendLetter();
		
		formatter.setLetterDate(date);
		formatter.setLetterDestinatary(person_destinatary);
		formatter.setLetterDestinataryAddress(address_destinatary);
		formatter.setLetterSender(person_sender);
		formatter.setLetterSenderAddress(address_sender);
}
	
	
	@Test
	public void FriendLetter() {
		formatter.setLetterBuilder(friendletter);
		formatter.constructLetter();
		assertEquals("Hospital\nSilent Hill\nMaine\n1918\nSpencer Mansion\nRacoon City\nKentucky\n1914\n28/6/1914\n\n\n\nQuerido Albert,\n\n"
				+ "<Escreva aqui a mensagem da carta>\n\n" + "Sinceramente,\n" + "\t\t\t\tHarry",formatter.getLetter());
	}
}
