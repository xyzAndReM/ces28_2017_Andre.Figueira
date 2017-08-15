package lab01;
import java.util.Currency;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagSimpleTest {
	private MoneyBag mb ;
	private MoneyBag mb2;
	private MoneyBag mb3;
	private MoneyBag dummy_bag;
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
	private Money JPY00 = new Money(0,JPY);
	private Money dummy_money;
	
	
	
	@Before
	public void setUp()  {
		dummy_money = new Money(0,USD);
		dummy_bag = new MoneyBag();
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
	}
	
	/**
	 * Contains Method
	 * O método contains deve dizer se existe uma cópia de dado elemento dentro da bag:
	 * Teste1: Mesmo que o money possua outro ponteiro este deve apontar como verdadeiro
	 * Teste2: Uma bag n deve conter conteudos nulos
	 * Teste3: Se uma bag contém 10 BRL, contains só resultará verdadeiro para exatamente
	 * 10 BRL, nada mais e nada menos.
	 * Teste4: Uma bag não deve conter aquilo que não foi adicionado.
	 * 
	 * 
	 * */
	@Test
	public void ContainsMethod_EqualMoneyDiffPointers() {
		assertTrue(mb.contains(other_CHF05));
	}
	@Test
	public void ContainsMethod_ShouldNotContain0AmountsMoneys() {
		assertFalse(mb.contains(JPY00));
	}
	@Test
	public void ContainsMethod_ContainsIsStrict() {
		mb.addMoney(BRL10);
		assertFalse(mb.contains(BRL10));
	}
	@Test
	public void ContainsMethod_ShouldNotContainMoneyThatWasNotAdded() {
		assertFalse(mb.contains(JPY15));
	}
	
	/**
	 * isZero Method
	 * Este método informa se a bag está ou não vazia
	 * Teste1: Se nada foi adicionado à bag, ela esta vazia
	 * Teste2: Se algo foi adicionado à bag então ela não está vazia
	 */
	@Test
	public void isZeroMethod_BuiltBagShoudBeEmpty() {
		assertTrue(dummy_bag.isZero());
		assertTrue(dummy_bag.size() == 0);
	}
	@Test
	public void isZeroMethod_AfterAddBagShoudNotBeEmpty() {
		dummy_bag.addMoney(JPY15);
		assertFalse(dummy_bag.isZero());
		assertTrue(dummy_bag.size() == 1);
	}
	
	/**
	 * addMoney Method
	 * Se money é adicionado à uma bag, então ele faz parte de seu contéudo.
	 * Teste1: Adicionar money à uma bag vazia, ela deixa de ser vazia e ela deve conter o money adicionado
	 * Teste2: Tentativa de adicionar money nulo de moeda que não existe dentro da bag
	 * Teste3: Tentativa de adicionar money nulo de moeda que existe dentro da bag
	 * Teste4: Várias adições de moneys de moedas diferentes, todos os moneys devem ser contidos.
	 * Teste5: Várias adições de moneys de mesma moeda não devem criar outro elemento dentro da bag e sim
	 * adicionar ao money da moeda já contido na bag
	 * Teste6: Quando um money é adicionado, a bag não deve sofrer mudanças se o objeto
	 * que originou a soma for destruido ou mudado (certificando-se q o objeto dentro da
	 * bag é uma copia do objeto adicionado)
	 */
	@Test //1
	public void MoneyBag_AddMoneyMethod_SimpleAdd() {
		//{} + CHF05 = {CHF05}
		dummy_bag.addMoney(CHF05);
		assertTrue(dummy_bag.size() == 1);
		assertTrue(dummy_bag.contains(CHF05));
		assertFalse(dummy_bag.isZero());
		assertEquals(dummy_bag,mb2);
	}
	@Test //2
	public void MoneyBag_AddMoneyMethod_0AmountAdded_BagDoesNotHaveTheCurrencyInside() {
		
		//{CHF05, BRL10, USD15} + JPY00 = {CHF05, BRL10, USD15}
		dummy_bag.addMoney(other_CHF05);
		dummy_bag.addMoney(other_BRL10);
		dummy_bag.addMoney(other_USD15);
		dummy_bag.addMoney(JPY00); //Should not add, therefore dummy_bag == mb
		assertEquals(dummy_bag,mb);
	}
	@Test //3
	public void MoneyBag_AddMoneyMethod_0AmountAdded_BagDoesHaveTheCurrencyInside() {
		
		//{CHF05, BRL10, USD15, JPY15} + JPY00 = {CHF05, BRL10, USD15, JPY15}
		dummy_bag.addMoney(JPY15);
		mb.addMoney(JPY15);
		dummy_bag.addMoney(JPY00);
		assertEquals(dummy_bag,mb);
	}
	@Test //4
	public void MoneyBag_AddMoneyMethod_MultipleAddDiffCurrencies() {
		assertTrue(mb.contains(BRL10));
		assertTrue(mb.contains(CHF05));
		assertTrue(mb.contains(USD15));
		assertFalse(mb.contains(JPY15));
		assertEquals(mb.size(),3);
		assertNotEquals(mb.size(),4);
	}
	@Test //5
	public void MoneyBag_AddMoneyMethod_MultipleAddEqualCurrencies() {
		
		dummy_bag.addMoney(CHF05);
		dummy_bag.addMoney(CHF05);
		assertFalse(dummy_bag.contains(CHF05));
		assertTrue(dummy_bag.size() == 1);
		assertFalse(dummy_bag.size() == 2);
		assertFalse(dummy_bag.isZero());
	}
	@Test //6
	public void MoneyBag_AddMoneyMethod_IfOriginalMoneyObjectAddedToTheBagIsChangedTheBagShouldNotFeelTheChange() {
		
		// Testing addMoney method
		dummy_money = USD15.cloneMoney();
		dummy_bag.addMoney(dummy_money);
		dummy_money = CHF05.cloneMoney();
		assertTrue(dummy_bag.contains(USD15));
		assertFalse(dummy_bag.contains(dummy_money));
		
	}
	/**
	 * Equals Method
	 * Teste de equivalência
	 * Teste1: bags iguais são equivalentes
	 * Teste2: A ordem dentro da bag não importa, testando equivalencia para mesma ordem
	 * Teste3: A ordem dentro da bag não importa, testando equivalencia para diferente ordem
	 * Teste4: Bags com moedas iguais  mas quantidades diferentes são diferentes.
	 * Teste5: Bags com moedas diferentes mas quantidades iguais são diferentes.
	 * Teste6: Bags com moedas e quantidades diferentes são diferentes
	 * Teste7: Mesmo que uma bag contenha outra mas possua elementos a mais, então ela é diferente
	 */
	@Test //1
	public void MoneyBag_EqualsMethod_Simple() {
		assertEquals(dummy_bag,dummy_bag);
		assertEquals(mb,mb);
	}
	@Test //2
	public void MoneyBag_EqualsMethod_EqualBags_SameOrderOfAdding() {
		//{BRL10, CHF05, USD15} == {BRL10, CHF05, USD15}
		dummy_bag.addMoney(other_BRL10) ;
		dummy_bag.addMoney(other_CHF05);
		dummy_bag.addMoney(other_USD15);
		assertTrue(dummy_bag.contains(BRL10));
		assertTrue(dummy_bag.contains(CHF05));
		assertTrue(dummy_bag.contains(USD15));
		assertEquals(dummy_bag.size(),3);
		assertEquals(mb,dummy_bag);
	}

	@Test //3
	public void MoneyBag_EqualsMethod_EqualBags_DiffOrderOfAdding() {
		//{BRL10, CHF05, USD15} == {BRL10, USD15, CHF05}
		dummy_bag.addMoney(other_BRL10) ;
		dummy_bag.addMoney(other_USD15);
		dummy_bag.addMoney(other_CHF05);
		assertTrue(dummy_bag.contains(BRL10));
		assertTrue(dummy_bag.contains(CHF05));
		assertTrue(dummy_bag.contains(USD15));
		assertEquals(dummy_bag.size(),3);
		assertEquals(mb,dummy_bag);
		assertTrue(mb.equals(dummy_bag));
		assertNotEquals(mb,mb2);
	}
	
	@Test //4
	public void MoneyBag_EqualsMethod_DiffBags_EqualCurrencies_DiffAmounts() {
		//{CHF01, BRL10, USD15} != { CHF05, BRL10, USD15}
		dummy_money.setAll(1,CHF);
		dummy_bag.addMoney(other_BRL10);
		dummy_bag.addMoney(dummy_money);
		dummy_bag.addMoney(other_USD15);
		assertNotEquals(mb,dummy_bag);	
	}
	@Test //5
	public void MoneyBag_EqualsMethod_DiffBags_DiffCurrencies_EqualAmounts() {
		// {BRL15} != {USD15}
		dummy_bag.addMoney(JPY15);
		dummy_bag.addMoney(USD15);
		assertNotEquals(mb,dummy_bag);	
	}
	@Test //6
	public void MoneyBag_EqualsMethod_DiffBags_DiffCurrencies_DiffAmounts() {
		// {BRL10} != {USD15}
		dummy_bag.addMoney(other_BRL10);
		dummy_bag.addMoney(other_USD15);
		assertNotEquals(mb,dummy_bag);	
	}
	@Test //7
	public void MoneyBag_EqualsMethod_DiffBags_BagContainsTheOtherButNotTheInverse() {
		//{JPY15, CHF05, BRL10, USD15} != { CHF05, BRL10, USD15}
		dummy_bag.addMoney(JPY15);
		dummy_bag.addMoney(other_CHF05);
		dummy_bag.addMoney(other_BRL10);
		dummy_bag.addMoney(other_USD15);
		assertNotEquals(mb,dummy_bag);	
	}

	
	
	
}