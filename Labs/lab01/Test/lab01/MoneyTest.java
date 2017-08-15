package lab01;

import static org.junit.Assert.*;

import java.util.Currency;

//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;


public class MoneyTest {

	private Currency CHF = Currency.getInstance("CHF");
	private Currency USD = Currency.getInstance("USD");
	private Money m12CHF;
	private Money m00CHF;
	private Money m14CHF;
	private Money m26CHF;
	private Money m26USD;
	private Money other_m26CHF;
	private Money other_m26USD;
	private Materia dummy_bag;
	private Materia dummy_bag2;
	
	/**
	 * ITEM NUMERO 4 !!!!!!!!!!!
	 */
	@Before
	public void setUp() {
		CHF = Currency.getInstance("CHF");
		USD = Currency.getInstance("USD");
		m12CHF = new Money(12,CHF);
		m00CHF = new Money(0,CHF);
		m14CHF = new Money(14,CHF);
		m26CHF = new Money(26,CHF);
		m26USD = new Money(26,USD);
		other_m26CHF = new Money(26,CHF);
		other_m26USD = new Money(26,USD);
		dummy_bag = new MoneyBag();
		dummy_bag2 = new MoneyBag();
	}

	@Test
	public void TheMoneyGeneratedByAddDoesNotHaveTheSamePointerAsMoneyWithSameParameters() {
		
		assertTrue(m26CHF != m12CHF.addMoney(m14CHF));
		}
	@Test
	public void Money_toStringMethod() {
		assertEquals(m12CHF.toString(),"12CHF");
		}
	/**
	 * AddMoney Method ITEM NUMERO 2,3 e 10 !!!!!!!!!!!!
	 * Teste1: Testando o método de ADD assumindo moedas iguais
	 * Teste2: Testando a comutatividade da operação de ADD
	 * Teste3: Testando o método de ADD mas agora considerando a adição de moedas difernetes, o resultado deve ser uma bag
	 * contendo os dois moneys sendo adicionados.
	 */
	@Test //1
	public void Money_AddMoneyMethod_EqualCurrency_Basic() {
		// 26CHF = 12CHF + 14CHF
		assertEquals(m26CHF, m12CHF.addMoney(m14CHF));
		// 14CHF = 14CHF + 00CHF
		assertEquals(m14CHF,m14CHF.addMoney(m00CHF));
		// 14CHF = 00CHF + 14CHF
		assertEquals(m14CHF,m00CHF.addMoney(m14CHF));
		}
	@Test //2
	public void Money_AddMoneyMethod_EqualCurrency_Comutatividade() {
		// 26CHF = 12CHF + 14CHF
		assertEquals(m26CHF, m12CHF.addMoney(m14CHF));
		// 26CHF = 14CHF + 12CHF
		assertEquals(m26CHF, m14CHF.addMoney(m12CHF));
		// 12CHF + 14CHF = 14CHF + 12CHF
		assertEquals(m12CHF.addMoney(m14CHF), m14CHF.addMoney(m12CHF));
		}
	@Test //3
	public void Money_AddMoneyMethod_DiffCurrencies_Basic() {
		//12CHF + 26 USD = {12CHF,26USD}  {...}  represents a bag
		dummy_bag =  m12CHF.addMoney(m26USD); //should return a moneybag
		dummy_bag2.addMoney(m12CHF);
		dummy_bag2.addMoney(other_m26USD);
		assertEquals(dummy_bag,dummy_bag2);
		dummy_bag2.addMoney(m12CHF);
		assertNotEquals(dummy_bag,dummy_bag2);
		}
	
	/**
	 * subMoney Method
	 * Teste1: Subtração de moneys de mesma moeda
	 * Teste2: Subtração de moneys de moedas diferentes,do nothing, raise exception
	 * Teste3: Subtração de moneys de moedas iguais porém de quanitdade insufisciente, do nothing, raise exception
	 * Teste4: Subtração de quantidades insufiscientes e de moedas diferentes, exception de moeda diferente tem prioridade
	 */
	@Test //1
	public void Money_SubMoneyMethod_EqualCurrency() {
		Money actual = new Money(26,CHF);
		//26CHF - 14CHF = 12CHF
		assertEquals(m12CHF, actual.subMoney(m14CHF)); 
		assertEquals(m26CHF, actual);
		}
	@Test(expected = DiffCurrencyException.class) //2
	public void Money_SubMoneyMethod_DiffCurrency_EnoughAmount() {
			//26CHF - 26USD -> 26CHF (DO NOTHING)
			Money actual = new Money(26,CHF);
			actual.subMoney(m26USD);
			assertEquals(actual,other_m26CHF);
		}
	@Test(expected = SaldoInsuficienteException.class) //3
	public void Money_SubMoneyMethod_SameCurrency_NotEnoughAmount() {
			//12CHF - 26CHF -> 12CHF (DO NOTHING)
			Money actual = new Money(12,CHF);
			actual.subMoney(m26CHF);
			assertEquals(actual,m12CHF);
		}
	@Test(expected = DiffCurrencyException.class) //4
	public void Money_SubMoneyMethod_DiffCurrency_NotEnoughAmount() {
			//12CHF - 26USD -> 12CHF (DO NOTHING)
			Money actual = new Money(12,CHF);
			actual.subMoney(m26USD);
			assertEquals(actual,m12CHF);
		}
}
