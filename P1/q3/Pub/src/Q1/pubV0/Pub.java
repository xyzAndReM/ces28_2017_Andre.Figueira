package Q1.pubV0;


public class Pub {

	private IngredientTable _Ingredients = new IngredientTable();
	private DrinkTable _Drinks = new DrinkTable();
    
    public int computeCost(String drink, boolean student, int amount) {
    	
    	Drink Pedido = _Drinks.getDrink(drink);
    	if(Pedido == null) {
    		throw new RuntimeException("No such drink exists");
    	}
        if (amount >  Pedido.getMaxAmount()) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        
        int price;
        
        price  = amount*Pedido.getPrice(_Ingredients);
        
        if(student && Pedido.getStudentDiscount()) {
        	price = price - price/10;
        }
        return price;
    }
}
