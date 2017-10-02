package Q3;

import static org.junit.Assert.*;

//import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q3.TireMonitor.Alarm;
import Q3.TireMonitor.MySensor;


public class AlarmTest {
	
	Alarm alarm;
	
	
	@Mock
	private MySensor TestSensor;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		alarm = new Alarm(TestSensor,17.0,21.0);
	}
	
	@Test
	public void AbaixoDoLimite() {
		Mockito.when(TestSensor.readPressure()).thenReturn(15.9);
		assertEquals(alarm.isAlarmOn(),true);
	}
	
	@Test
	public void AcimaDoLimite() {
		Mockito.when(TestSensor.readPressure()).thenReturn(32.3);
		assertEquals(alarm.isAlarmOn(),true);
	}
	
	@Test
	public void DentroDoLimite() {
		Mockito.when(TestSensor.readPressure()).thenReturn(18.9);
		assertEquals(alarm.isAlarmOn(),false);
	}
	
}
