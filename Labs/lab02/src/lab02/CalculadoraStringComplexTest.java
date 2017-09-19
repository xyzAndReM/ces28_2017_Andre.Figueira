package lab02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraStringComplexTest {
	
	
	@Test
	public void MinusSeparator() {
		String simples = new String();
		simples = "\\[-][p]\n1-2-3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test
	public void SpaceSeparator() {
		String simples = new String();
		simples = "\\[ ][p]\n1 2     3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test
	public void AsteriskSeparator() {
		String simples = new String();
		simples = "\\[*][p]\n1*2*3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void InvertedBarSeparator() {
		String simples = new String();
		simples = "\\[\\][p]\n1\\2\\3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void LongSeparator() {
		String simples = new String();
		simples = "\\[aaa][p]\n1aa2aa3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void barDseparator() {
		String simples = new String();
		simples = "\\[\\D][p]\n1\\D2\\D3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void aspasSeparator() {
		String simples = new String();
		simples = "\\['][p]\n1'2'3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void multipleAsterisksSeparator() {
		String simples = new String();
		simples = "\\[*][**][**][p]\n1*2**3***4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void multipleAsterisksSeparatorButOnlyOneSeparatorOnStringRaiseException() {
		String simples = new String();
		simples = "\\[**][p]1\n*2*3*4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void multipleAsterisksSeparatorButSeparatorisHigherYetNotMultiple() {
		String simples = new String();
		simples = "\\[**][p]1\n***2***3***4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
	@Test
	public void MinusStringAsDelimitersNoMinusLeft() {
		String simples = new String();
		simples = "\\[--][---]\n1-----2--3---4";
		assertEquals(10,CalculadoraString.add(simples));
		
	}
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void MinusStringAsDelimiters1MinusLeft() throws Exception{
		String simples = new String();
		expectedEx.expect(NegativeNumbersException.class);
		expectedEx.expectMessage("negativos proibidos [-2 -3 -5 ]");
		simples = "\\[-----][------]\n1-------2-------3,-5";
		assertEquals(11,CalculadoraString.add(simples));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void MinusStringAsDelimiters2MinusLeft() {
		String simples = new String();
		simples = "\\[-----][------]\n1--------2,3,4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
	
	
	
}
