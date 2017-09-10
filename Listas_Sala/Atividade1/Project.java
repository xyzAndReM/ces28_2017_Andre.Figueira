	package v0;
	
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
	
public class Project {
  public Project() {
	  participants = new ArrayList<Person>();
  }
 
  private List<Person> participants;
  
  public List<Person> getParticipants() { return Collections.unmodifiableList(participants); }
  public int getNumberOfParticipants() { return participants.size(); }
  public void addParticipant(Person P) { participants.add(P); }
  public void removeParticipant(Person P) { 
	  
	  if(this.isParticipant(P)) {
		  participants.remove(P); 
	  }
	  // Else raise exception!
  }

  public void printParticipants() {
	  for (int i=0; i < participants.size(); i++)
		  System.out.println("project has person "+participants.get(i).getId());
  }
  
  public boolean isParticipant(Person p) {
		return participants.contains(p);
	}
}

