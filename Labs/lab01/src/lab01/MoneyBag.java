package lab01;
import java.util.*;

public class MoneyBag implements Materia  {
	LinkedHashMap<Currency,Money> _Bag  = new LinkedHashMap<Currency,Money>();
	
	/**Retorna o n�mero de moneys dentro da bag **/
	public int size() { return _Bag.size(); }
	
	/**Retorna string com o conte�do dentro da bag 
	 * ITEM NUMERO 9**/
	public String toString() {
		String contents = new String();
		for(Currency coin: _Bag.keySet()){
           contents +=  "" + _Bag.get(coin).toString() + "\n";
        }
		return _Bag.values().toString();
	}
	/** Retorna boolean informando se h� zero termos dentro da bag**/
	public boolean isZero() {
		return _Bag.size() == 0;
	}
	
	/**Adiciona money � bag, se o money adicionado possui valor nulo ent�o ele n�o � adicionado.
	 * @param m money a ser adicionado � bag
	 * @return this a pr�pria bag � qual o money foi adicionado
	 *  **/
	public Materia addMoney(Money m) {
		Currency coin = m.getCurrency();
		int amount;
		Money new_money = null;
		if(m.getAmount() > 0) {
			if ( _Bag.containsKey( coin ) ) {
				amount = m.getAmount() + _Bag.get(coin).getAmount();
				new_money = new Money(amount,coin);
				_Bag.put(coin, new_money);
			}
			else {
				Money copia = m.cloneMoney();
				_Bag.put(copia.getCurrency(),copia);
			}
		}
		return this;
	}
	/**Adiciona uma bag � esta.
	 * @param m bag a ser adicionado � bag
	 * @return this a pr�pria bag � qual a bag foi adicionada
	 *  **/
	public MoneyBag addBag(MoneyBag m) {
		
			for(Currency coin: m.getBag().keySet()){
	            this.addMoney(m.getMoney(coin));
	        }
			return this;
	}
	/**Subtrai um money desta bag.
	 * @param m money a ser subtra�do
	 * @return this a pr�pria bag � qual o money foi subtra�do
	 *  **/
	public MoneyBag subMoney(Money m) {
		Currency coin = m.getCurrency();
		int amount;
		if ( _Bag.containsKey( coin ) ) {
			amount = -m.getAmount() + _Bag.get(coin).getAmount();
			if(amount >= 0) {
				Money new_money = new Money(amount,coin);
				_Bag.put(coin, new_money);
				this.removeEmptyPockets(new_money);
			}
			else {
				throw new SaldoInsuficienteException("N�o h� dinheiro suficiente");
			}
		}
		else {
			throw new DiffCurrencyException("Opera��o de subtra��o entre moedas diferentes n�o � permitido");
		}
		return this;
	}
	/**Subtrai uma bag desta bag.
	 * @param m a bag a ser subtra�da
	 * @return this a pr�pria bag � qual a bag foi subtra�da
	 *  **/
	public MoneyBag subBag(MoneyBag m) {
		MoneyBag collector = new MoneyBag();
		boolean flag = true;
		for(Currency coin: m.getBag().keySet()  ){
		if(flag) {
			try {
				this.subMoney(m.getMoney(coin));
				collector.addMoney(m.getMoney(coin));
			}
			catch(DiffCurrencyException | SaldoInsuficienteException  ex) {
				this.addBag(collector);
				flag = false;
				throw ex;
			}
		}
			
		}
		return this;
	}
	
	
	/** Remove da bag moneys com 0 amount
	 * 
	 * @param m money passivel de elimina��o
	 */
	private void removeEmptyPockets(Money m) {

		if(m != null && m.getAmount() == 0) {
			_Bag.remove(m.getCurrency());
		}
	}
	/** Converte dolares e francos suissos em reais.
	 *	ITEM NUMERO 11 !!!!!!!!!!!!
	 * @return Um money de moeda BRL no valor convertido
	 */
	public Materia convertBRL() {
		Integer amount = 0;
		Money usd = _Bag.get(Currency.getInstance("USD"));
		Money chf = _Bag.get(Currency.getInstance("CHF"));
		Money brl = _Bag.get(Currency.getInstance("BRL"));
		if(usd != null) {
		amount += usd.getAmount()*3;	
		}
		if(chf != null) {
			amount += chf.getAmount()*2;	
		}
		if(brl != null) {
			amount += brl.getAmount()*1;	
		}
		return new Money(amount,Currency.getInstance("BRL"));
		
	}
	/**Cria uma nova money bag a partir de dois moneys
	 * 
	 * @param m1 um money qualquer
	 * @param m2 outro money
	 * @return uma MoneyBag contendo m1 e m2
	 */
	public static Materia Create(Money m1,Money m2) {
		MoneyBag bag = new MoneyBag();
		bag.addMoney(m1);
		bag.addMoney(m2);
		return bag;
	}
	
	
	public Money getMoney(Currency currency) { return _Bag.get(currency).cloneMoney(); }
	
	public LinkedHashMap<Currency,Money> getBag() {return (LinkedHashMap<Currency,Money>) _Bag.clone();}
	
	public void setBag(LinkedHashMap<Currency,Money> mb) {_Bag = mb;}
	
	public boolean contains(Money m) {return _Bag.containsValue(m); }
	
	@Override
	/** Equals method
	 * 
	 */
	public boolean equals(Object anObject) {
		MoneyBag aMoneyBag = (MoneyBag) anObject;
		return _Bag.equals(aMoneyBag.getBag());
	}//equals
}
