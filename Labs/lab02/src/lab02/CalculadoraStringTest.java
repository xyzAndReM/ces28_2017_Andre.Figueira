package lab02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraStringTest {
	
	
	@Test
	public void SimpleTest() {
		String simples = new String();
		simples = "1,2,3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test
	public void EmptyString() {
		String simples = new String();
		simples = "";
		assertEquals(0,CalculadoraString.add(simples));
	}
	@Test
	public void SpacedDigitsSimple() {
		String simples = new String();
		simples = "   2    , 3,     3";
		assertEquals(8,CalculadoraString.add(simples));
	}
	
	@Test
	public void VoidFields() {
		String simples = new String();
		simples = ",,,";
		assertEquals(0,CalculadoraString.add(simples));
		simples = "1,,";
		assertEquals(1,CalculadoraString.add(simples));
		simples = ",1,";
		assertEquals(1,CalculadoraString.add(simples));
		simples = ",,1,,6,";
		assertEquals(7,CalculadoraString.add(simples));
		simples = ",,,,1";
		assertEquals(1,CalculadoraString.add(simples));
	}
	
	@Test(expected = NegativeNumbersException.class)
	public void NegativeNumbers() {
		String simples = new String();
		simples = "-1,-2,3,4";
		assertEquals(7,CalculadoraString.add(simples));
		simples = "-2";
		assertEquals(0,CalculadoraString.add(simples));
		simples = "--1,-2,3";
		assertEquals(3,CalculadoraString.add(simples));
	}
	@Test
	public void IgnoreHigherThan1000() {
		String simples = new String();
		simples = "1020,	2";
		assertEquals(2,CalculadoraString.add(simples));
		simples = "3000,3,2333,999";
		assertEquals(1002,CalculadoraString.add(simples));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void NegativeNumbersExceptionMessage() throws Exception {
	    expectedEx.expect(NegativeNumbersException.class);
	    expectedEx.expectMessage("negativos proibidos [-1 -5 -3 -1002]");
	    String simples = new String();
		simples = "-1,-5,3,4,-3,-1002";
	    assertEquals(4,CalculadoraString.add(simples));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NotDefinedSeparatorSimple() {
		String simples = new String();
		simples = "1;2;3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void SeparatedBySpaces() {
		String simples = new String();
		simples = "1 2,3 4,,,";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void SeparatedByEnter() {
		String simples = new String();
		simples = "  1  \n2   \n			3";
		assertEquals(6,CalculadoraString.add(simples));
	}
	@Test
	public void SeparatedByEnterAndCommas() {
		String simples = new String();
		simples = ",,\n1  \n2   ,,,\n\n\n   3,34,1002";
		assertEquals(40,CalculadoraString.add(simples));
	}
	@Test(expected = IllegalArgumentException.class)
	public void OtherCharactersBesidesDigits() {
		String simples = new String();
		simples = "a,2,3,c";
		assertEquals(5,CalculadoraString.add(simples));
	}
	
	@Test
	public void DefinedSingleSeparatorSimple() {
		String simples = new String();
		simples = "\\[;]\n1;2;3,4\n0";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
	@Test
	public void DefinedMultipleSeparatorSimple() {
		String simples = new String();
		simples = "\\[;][][p]\n1p2p3;4\n0";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DefinedMultipleSeparatorFailure() {
		String simples = new String();
		simples = "\\[;][-][p]\n-1-2-3a4";
		assertEquals(10,CalculadoraString.add(simples));
	}
	
}
