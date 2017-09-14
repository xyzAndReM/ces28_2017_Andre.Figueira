package lab02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraStringComplexTest {
	
	
	@Test
	public void MinusSeparator() {
		String simples = new String();
		simples = "\\[-][p]1-2-3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test
	public void SpaceSeparator() {
		String simples = new String();
		simples = "\\[ ][p]1 2     3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test
	public void AsteriskSeparator() {
		String simples = new String();
		simples = "\\[*][p]1*2*3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void InvertedBarSeparator() {
		String simples = new String();
		simples = "\\[\\][p]1\\2\\3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void LongSeparator() {
		String simples = new String();
		simples = "\\[aaa][p]1aa2aa3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void barDseparator() {
		String simples = new String();
		simples = "\\[\\D][p]1\\D2\\D3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void aspasSeparator() {
		String simples = new String();
		simples = "\\['][p]1'2'3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void multipleAsterisksSeparator() {
		String simples = new String();
		simples = "\\[*][**][**][p]1*2**3***4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void multipleAsterisksSeparatorButOnlyOneSeparatorOnStringRaiseException() {
		String simples = new String();
		simples = "\\[**][p]1*2*3*4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
	
}
