package Q1.pubV0;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class IngredientTable {
	
	private LinkedHashMap<String,Integer> _IngredientList  = new LinkedHashMap<String,Integer>();
	
	public IngredientTable() {
		_IngredientList.put("beer",74);
		_IngredientList.put("cider",103);
		_IngredientList.put("propercider",110);
		_IngredientList.put("rum",65);
		_IngredientList.put("grenadine",10);
		_IngredientList.put("limejuice",10);
		_IngredientList.put("greenstuff",10);
		_IngredientList.put("tonicwater",20);
		_IngredientList.put("gin",85);
	}
	
	public void add(String ingredient,int price) {
		_IngredientList.put(ingredient, price);
	}
	
	public int price_of_list(String[] ingredientList) {
		int final_price = 0;
		String ingredient;
		for (int i = 0; i < ingredientList.length; i++) {
			ingredient = ingredientList[i];
            final_price += _IngredientList.get(ingredient);
        }
		return final_price;
	}
    
}
