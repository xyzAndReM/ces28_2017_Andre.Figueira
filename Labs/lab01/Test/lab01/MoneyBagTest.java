package lab01;
import java.util.Currency;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {
	private MoneyBag mb ;
	private MoneyBag mb2;
	private MoneyBag mb3;
	private MoneyBag dummy_bag;
	private MoneyBag dummy_bag2;
	private Currency BRL = Currency.getInstance("BRL");
	private Currency CHF = Currency.getInstance("CHF");
	private Currency USD = Currency.getInstance("USD");
	private Currency JPY = Currency.getInstance("JPY");
	private Money BRL10 = new Money(10,BRL);
	private Money CHF05 = new Money(5,CHF);
	private Money USD15 = new Money(15,USD);
	private Money JPY15 = new Money(15,JPY);
	private Money other_USD15 = new Money(15,USD);
	private Money other_BRL10 = new Money(10,BRL);
	private Money other_CHF05 = new Money(5,CHF);
	private Money other_JPY15 = new Money(15,JPY);
	private Money JPY00 = new Money(0,JPY);
	private Money dummy_money;
		
	@Before
	public void setUp()  {
		dummy_money = new Money(0,USD);
		dummy_bag = new MoneyBag();
		dummy_bag2 = new MoneyBag();
		mb = new MoneyBag();
		mb2= new MoneyBag();
		mb3= new MoneyBag();
		mb.addMoney(BRL10);
		mb.addMoney(CHF05);
		mb.addMoney(USD15);
		mb2.addMoney(CHF05);
		mb3.addMoney(JPY15);
		mb3.addMoney(JPY00);
		mb3.addMoney(USD15);
		/**
		 * mb = {BRL10, CHF05, USD15} ; mb2 = {CHF05} ; mb3 = {JPY15, USD15}
		 */
	}
	
	
	
	/**
	 * SubMoney Method
	 * Este m�todo subtrai money da bag, se h� incoer�ncia de quantidade (insufisci�ncia) ou de moeda ent�o
	 * nada acontece e uma excep��o � levantada.
	 * Teste1: Caso simples em que a bag cont�m a moeda em quantidade suficiente
	 * Teste2: Caso em que h� a moeda correspondente por�m quantidade insufisciente, espera-se exce��o e que nada ocorra
	 * Teste3: Caso em que n�o h� compatibilidade de moedas,  espera-se exce��o e que nada ocorra
	 * Teste4: Caso em que se retira precisamente a quantidade exata de uma moeda na bag, para este caso o money dentro
	 * da bag deve ser retirado tendo em vista que dentro de uma bag n�o pode haver money nulo.
	 */
	@Test //1
	public void MoneyBag_SubMoneyMethod_BagContainsCurrency_EnoughAmount() {
		// {JPY15} - JPY5 = {JPY10}
		dummy_bag.addMoney(JPY15);
		dummy_money.setAll(5, JPY);
		dummy_bag.subMoney(dummy_money);
		dummy_money.setAll(10, JPY);
		dummy_bag2.addMoney(dummy_money);
		assertEquals(dummy_bag,dummy_bag2);
		
		// {JPY10, BRL15} - BRL05 = {JPY10, BRL10}
		dummy_money.setAll(15, BRL);
		dummy_bag.addMoney(dummy_money);
		dummy_bag2.addMoney(BRL10);
		dummy_money.setAll(5, BRL);
		dummy_bag.subMoney(dummy_money);
		assertEquals(dummy_bag,dummy_bag2);
	}
	@Test(expected = SaldoInsuficienteException.class) //2
	public void MoneyBag_SubMoneyMethod_BagContainsCurrency_NotEnoughAmount_DoNothing_RaiseException() {
		//{JPY15} - JPY50 -> {JPY15}
		dummy_bag.addMoney(JPY15);
		dummy_money.setAll(50, JPY);
		dummy_bag.subMoney(dummy_money);
		dummy_bag2.addMoney(JPY15);
		assertEquals(dummy_bag,dummy_bag2);
	}
	@Test(expected = DiffCurrencyException.class) //3
	public void MoneyBag_SubMoneyMethod_BagDoesNotContainsCurrency_DoNothing_RaiseException() {
		//{JPY15} - USD50 -> {JPY15}
		dummy_bag.addMoney(JPY15);
		dummy_money.setAll(50, USD);
		dummy_bag.subMoney(dummy_money);
		dummy_bag2.addMoney(JPY15);
		assertEquals(dummy_bag,dummy_bag2);
	}
	@Test//4
	public void MoneyBag_removeEmptyPocketsMethod_ABagCannotContainMoneyOfZeroAmount() {
		//{BRL10, USD15, CHF05} - BRL10 - USD15 = {CHF05}
		mb.subMoney(BRL10);
		mb.subMoney(other_USD15);
		assertEquals(mb,mb2);
		//{CHF05} + 00JPY = {CHF05}
		mb.addMoney(JPY00);
		assertEquals(mb,mb2);
	}
	/**
	 * AddBag Method
	 * Este m�todo adiciona uma bag � outra
	 * Teste1: Caso simples em que uma bag contem todas as moedas da outra
	 * Teste2: Caso em que h� a moeda correspondente por�m quantidade insufisciente, espera-se exce��o e que nada ocorra
	 * Teste3: Caso em que n�o h� compatibilidade de moedas,  espera-se exce��o e que nada ocorra
	 */
	@Test
	public void MoneyBag_addBagMethod_SimpleAddBagTest_BagContainsAllCurrenciesOfTheOther() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb2);
		dummy_bag2.addMoney(other_CHF05);
		dummy_bag2.addMoney(BRL10);
		dummy_bag2.addMoney(other_USD15);
		dummy_bag2.addMoney(CHF05);
		assertEquals(dummy_bag,dummy_bag2);
	}
	@Test
	public void MoneyBag_addBagMethod_SimpleAddBagTest_BagDoesNotContainsAllCurrenciesOfTheOther() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb3);
		dummy_bag2.addMoney(other_CHF05);
		dummy_bag2.addMoney(BRL10);
		dummy_bag2.addMoney(other_USD15);
		dummy_bag2.addMoney(other_USD15);
		dummy_bag2.addMoney(JPY15);
		assertEquals(dummy_bag,dummy_bag2);
	}
	@Test
	public void MoneyBag_addBagMethod_AddEmptyBag() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(dummy_bag2);
		assertEquals(dummy_bag,mb);
	}
	/**------------------------------------EXTRA------------------------------------------------*/
	@Test
	public void MoneyBag_subBagMethod_BagBeingSubtractedHasAllCurrenciesFromTheSubtractingOneAndEnoughAmount() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb);
		dummy_bag2.addBag(mb);
		dummy_bag2.addBag(mb);
		
		dummy_bag.subBag(mb);
		//assertEquals(dummy_bag,dummy_bag2);
		
		dummy_bag.addBag(dummy_bag);
		dummy_bag.subBag(mb);
		dummy_bag.subBag(mb);
		assertEquals(dummy_bag,dummy_bag2);////errado
	}
	@Test(expected = SaldoInsuficienteException.class)
	public void MoneyBag_subBagMethod_NotEnoughAmount_DoNothingRaiseException() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb); //dummy_bag has 2 mbs
		dummy_bag2.addBag(mb);
		dummy_bag2.addBag(mb);
		dummy_bag2.addBag(mb); //dummy_bag2 has 3 mbs
		
		dummy_bag.subBag(dummy_bag2); //does nothing
		dummy_bag2.subBag(mb); //dummy_bag2 has 2 mbs now
		assertEquals(dummy_bag,dummy_bag2); //they should be equal now
	}
	@Test(expected = DiffCurrencyException.class)
	public void MoneyBag_subBagMethod_BagBeingSubtractedHasDiffCurrenciesFromTheSubtractingOneButEnoughAmount_DoNothing_RaiseException() {
		dummy_bag.addBag(mb);
		dummy_bag.addBag(mb); //dummy_bag has 2 mbs
		dummy_bag2.addMoney(JPY15);
		dummy_bag2.addBag(mb); // dummy_bag2 has 1mb and 15 JPY
		
		dummy_bag.subBag(dummy_bag2); //does nothing
		dummy_bag.subBag(mb); //dummy_bag has 1 mb now
		assertEquals(dummy_bag,mb); //they should be equal now if the does nothing operation worked as intended
	}
	/**----------------------------------fim do extra-----------------------------------------------
	@Test
	/**
	 * �TEM NUMERO 11
	 */
	public void MoneyBag_convertBRLMethod() {
		//mb = {BRL10, CHF05, USD15} -> 3x15 + 2x5 + 10 = 65
		dummy_money.setAll(65, BRL);
		assertEquals(dummy_money,mb.convertBRL());
		//mb2 = {CHF05} -> 2x5 = 10
		dummy_money.setAll(10, BRL);
		assertEquals(dummy_money,mb2.convertBRL());
		//{} -> 0
		dummy_money.setAll(0, BRL);
		assertEquals(dummy_money,dummy_bag.convertBRL());
		
	}
	
	@Test
	/**
	 * �TEM NUMERO 9
	 */
	public void MoneyBag_toString() {
		//mb = {BRL10, CHF05, USD15}
		assertEquals(mb.toString(),"[10BRL, 5CHF, 15USD]");
		//mb2 = {CHF05}
		assertEquals(mb2.toString(),"[5CHF]");
		//dummy_bag = {0}
		assertEquals(dummy_bag.toString(),"[]");
		
		dummy_bag.addMoney(JPY15);
		dummy_bag.addMoney(USD15);
		//{JPY15 USD15}
		assertEquals(dummy_bag.toString(),"[15JPY, 15USD]");
		
		
	}
	
	
	
}

