package lab01;

public interface Materia {

	 /**
     * Adds a money to this money.
     */
    //Material add(Material m);

    /**
     * Adds a simple Money to this money. This is a helper method for
     * implementing double dispatch
     */
    Materia addMoney(Money m);

    /**
     * Adds a MoneyBag to this money. This is a helper method for
     * implementing double dispatch
     */
    Materia addBag(MoneyBag s);

    /**
     * Tests whether this money is zero
     */
    boolean isZero();

    /**
     * Multiplies a money by the given factor.
     */
    //Material multiply(int factor);

    /**
     * Negates this money.
     */
    //Material negate();

    /**
     * Subtracts a money from this money.
     */
    Materia subMoney(Money m);

    /**
     * Append this to a MoneyBag m.
     * appendTo() needs to be public because it is used
     * polymorphically, but it should not be used by clients
     * because it modifies the argument m.
     */
    //void appendTo(MoneyBag m);
}
