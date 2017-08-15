package lab01;
import java.util.Currency;

public class Money implements Materia {
	
	/** Construtor ITEM NUMERO 5 !!!!!!! **/
	public Money(Integer amount, Currency coin) {
		_currency = coin;
		_amount   = amount;
	}
	
	@Override
	/** Retorna string contendo a quantidade e moeda**/
	public String toString(){
		return "" + getAmount() +  getCurrency();
	}
	
	/** Retorna boolean afirmando se a quantidade de money é nula ou não**/
	public boolean isZero() {
		return getAmount() == 0;
	}
	
	/** Equals method**/
	@Override
    public boolean equals(Object anObject) {
        if (isZero()) {
            if (anObject instanceof Materia) {
                return ((Materia) anObject).isZero();
            }
        }
        if (anObject instanceof Money) {
            Money aMoney = (Money) anObject;
            return aMoney.getCurrency().equals(getCurrency())
                    && getAmount() == aMoney.getAmount();
        }
        return false;
    }
	
	/**Adds money to the object, if the money is of same currency then returns money with the amounts summed
	, case contrary a MoneyBag is built  containing the two moneys in question and is returned
	ITEM NUMERO 10**/
	public Materia addMoney(Money m) {
		if (m.getCurrency().equals(this.getCurrency())) {
            return new Money(this.getAmount() + m.getAmount(), this.getCurrency());
        }
        return MoneyBag.Create(this, m);
		}
	public Materia addBag(MoneyBag mb) {
		return mb.addMoney(this);
	}
	
	/**Substracts money from the object, if the currencies are different or the amount from the object is not enough
	 to be substracted then nothing happens but a raising of exception*/
	public Money subMoney(Money m) {
		if(m.getCurrency() == this.getCurrency()) {
			int new_amount = this.getAmount() - m.getAmount();
			if(new_amount >= 0) {
				return new Money(new_amount,m.getCurrency());
			}
			else {
				throw new SaldoInsuficienteException("Não há dinheiro suficiente");
			}
		}
		else {
			throw new DiffCurrencyException("Operação de subtração entre moedas diferentes não é permitido");
		}
	}
	
	/** Returns a new money that is a copy of this object**/
	public Money cloneMoney() {
		Money clone = new Money(this.getAmount(),this.getCurrency());
		return clone;
	}
	
	/**Setters and Getters**/
	public int getAmount() {
		return _amount.intValue();
	}
	public void setAmount(int amount) {
		this._amount = amount;
	}
	public Currency getCurrency() {
		String coin;
		coin = _currency.getCurrencyCode();
		return Currency.getInstance(coin);
	}
	public void setCurrency(Currency currency) {
		this._currency = currency;
	}
	public void setAll(int amount, Currency currency) {
		this.setAmount(amount);
		this.setCurrency(currency);
	}
	
	private Integer _amount;
	private Currency _currency;
}
