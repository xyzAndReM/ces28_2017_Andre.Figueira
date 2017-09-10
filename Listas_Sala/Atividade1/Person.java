package v0;


public class Person {
	static int nextId=0;
	public Person(){
		id = nextId++;
	}
	   
	public int getId() {
	  return id;
	}
	
	private int id;
}
