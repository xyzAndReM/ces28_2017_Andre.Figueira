package Q1.pubV0;

import java.util.LinkedList;

public class Drink {
		private String _name;
		private boolean _studentDiscount;
		private int _maxAmount;
		private String[]  _ingredientList;
		
		public Drink(String name, boolean studentDiscount, int maxAmount,String[] ingredients ) {
			_name = name;
			_studentDiscount = studentDiscount;
			_maxAmount = maxAmount;
			_ingredientList = ingredients;
		}
		public Drink(String name, boolean student_discount, int maxAmount) {
			_name = name;
			_studentDiscount = student_discount;
			_maxAmount = maxAmount;
		}
		
		public int getMaxAmount() {
			return _maxAmount;
		}
		
		public boolean getStudentDiscount() {
			return _studentDiscount;
		}
		
		public String[] getIngredientList() {
			return _ingredientList;
		}
		
		public int  getPrice(IngredientTable ingredients) {
			return ingredients.price_of_list(_ingredientList);
		}
		
		
		
		
}
