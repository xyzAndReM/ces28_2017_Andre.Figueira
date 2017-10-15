package Exercicio1;



import static org.junit.Assert.*;
import org.junit.Test;

import Excercicio1.Address;
import Excercicio1.Date;

import org.junit.Before;

public class SimpleTests {
	
	Address address;
	String street = "Spencer Mansion";
	String city   = "Racoon City";
	String state = "Kentucky";
	String zipcode = "1914";
	
	Date date;
	int day   = 28;
	int month = 6;
	int year  = 1914;
		
	
	@Before
	public void setUp(){
		address = new Address(street,city,state,zipcode);
		date = new Date(day,month,year);
}
	
	
	@Test
	public void Address_toPrint() {
		assertEquals("Spencer Mansion\nRacoon City\nKentucky\n1914\n",address.toPrint());
	}
	@Test
	public void Date_toPrint() {
		assertEquals("28/6/1914\n",date.toPrint());
	}

}
