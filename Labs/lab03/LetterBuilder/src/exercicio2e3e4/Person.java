package exercicio2e3e4;

public class Person {
	String _FirstName;
	String _LastName;
	String _Gender;
	String _Title;
	Phone _PhoneNumber;
	String _Email;
	
	public Person(String firstname, String lastname,String gender, String title, Phone phonenumber, String email){
		_FirstName = firstname;
		_LastName = lastname;
		_Gender = gender;
		_Title = title;
		_PhoneNumber = phonenumber;
		_Email = email;
	}
	
	
	String first_name() {
		return _FirstName;
	}
	
	String last_name() {
		return _LastName;
	}
	
	String gender() {
		return _Gender;
	}
	
	String title() {
		return _Title;
	}
	
	Phone phone_number() {
		return _PhoneNumber;
	}
	
	String email() {
		return _Email;
	}
}
