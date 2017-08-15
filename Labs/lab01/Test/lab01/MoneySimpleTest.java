package lab01;

import static org.junit.Assert.*;

import java.util.Currency;

import org.junit.Test;
import org.junit.Before;
public class MoneySimpleTest {
	
	private Currency CHF = Currency.getInstance("CHF");
	private Currency USD = Currency.getInstance("USD");
	private Currency other_CHF = Currency.getInstance("CHF");
	private Currency other_USD = Currency.getInstance("USD");
	
	private Money m12CHF;
	private Money m00CHF;
	
	@Before
	public void setUp(){
			m12CHF = new Money(12,CHF);
			m00CHF = new Money(00,CHF);
	}
	/**Testa o método isZero**/
	@Test
	public void Money_isZeroMethod() {
		Money actual = new Money(0,USD);
		Money actual2 = new Money(2,USD);
		//0USD IS ZERO? YES
		assertTrue(actual.isZero() );
		//2USD IS ZERO? NO
		assertFalse(actual2.isZero() );
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 são iguais**/
	@Test
	public void Currency_EqualsMethod_Equals() {
		//CHF = CHF YES
		assertEquals(CHF, other_CHF);
		assertEquals(CHF, CHF);// (1)
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 NÃO são iguais**/
	@Test
	public void Currency_EqualsMethod_NotEquals() {
		assertNotEquals(other_CHF, other_USD);
		//CHF != USD YES
		assertNotEquals(CHF, USD);
		// CHF != NULL YES
		assertNotEquals(CHF, null);
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 são iguais**/
	@Test
	public void Money_EqualsMethod_EqualAmount_EqualCurrency() {
		
		Money actual = new Money(12,CHF);
		//12CHF = 12CHF YES
		assertEquals(m12CHF, actual);
		
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 NÃO são iguais por diferença de quantidade**/
	@Test
	public void Money_EqualsMethod_NotEqualAmount_EqualCurrency() {
		
		Money actual = new Money(13,CHF);
		//12CHF != 13CHF YES
		assertNotEquals(m12CHF, actual);
		
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 NÃO são iguais por diferença de moeda**/
	@Test
	public void Money_EqualsMethod_EqualAmount_NotEqualCurrency() {
		Money actual = new Money(12,USD);
		assertNotEquals(m12CHF, actual);
		}
	
	/**Testa o método Equals para o caso em que os objetos em comparação 
	 NÃO são iguais por diferença de moeda e por diferença de quantidade**/
	@Test
	public void Money_EqualsMethod_NotEqualAmount_NotEqualCurrency() {
		
		Money actual = new Money(17,USD);
		assertNotEquals(m12CHF, actual);
		
		}
	
	/** Testa se dinheiros de iguais moedas porém de quantidades nulas são identificados
	 * como iguais como deve ser
	 */
	@Test
	public void Money_EqualsMethod_EmptyAmount_EqualCurrency() {
		/** Zero of certain currency is the same as zero for another currency**/
		Money actual = new Money(0,USD);
		assertEquals(m00CHF, actual);
		
		}
	
	/** Testa se dinheiros de diferentes moedas porém de quantidades nulas são identificados
	 * como iguais como deve ser
	 */
	@Test
	public void Money_EqualsMethod_EmptyAmount_NotEqualCurrency() {
		/** Zero of certain currency is the same as zero for another currency**/
		Money actual = new Money(0,CHF);
		assertEquals(m00CHF, actual);
		
		}
	
	

}
