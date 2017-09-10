package v1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import v0.Person;
import v0.Project;

public class UnitTests {
	
	private Project testProject = new Project();
	private Person testPersonA = new Person();
	private Person testPersonB = new Person();
	private Person testPersonC = new Person();
	
	@Before
	public void setUp() {
		testProject.addParticipant(testPersonA);
		testProject.addParticipant(testPersonB);
	}
	
	@Test
	public void checkIds() {
		assertEquals(testPersonA.getId(),1);
		assertEquals(testPersonB.getId(),2);
		assertEquals(testPersonC.getId(),3);
	}
	
	@Test
	public void checkInitialList() {
		assertTrue(testProject.isParticipant(testPersonA));
		assertTrue(testProject.isParticipant(testPersonB));
		assertFalse(testProject.isParticipant(testPersonC));
		assertEquals(testProject.getNumberOfParticipants(),2);
	}
	
	@Test
	public void checkNumberOfParticipants() {
		testProject.addParticipant(testPersonC);
		assertEquals(testProject.getNumberOfParticipants(),3);
	}
	@Test
	public void checkAdd() {
		testProject.addParticipant(testPersonC);
		assertTrue(testProject.isParticipant(testPersonC));
	}
	
	@Test
	public void checkRemove() {
		testProject.removeParticipant(testPersonB);
		assertFalse(testProject.isParticipant(testPersonB));
	}
	
}
