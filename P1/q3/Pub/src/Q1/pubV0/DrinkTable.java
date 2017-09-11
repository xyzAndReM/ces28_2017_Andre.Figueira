package Q1.pubV0;

import java.util.LinkedHashMap;

public class DrinkTable {
	private LinkedHashMap<String,Drink>_DrinkList=new LinkedHashMap<String,Drink>();
	public DrinkTable() {
		String[] Ibeer = {"beer"};
		String[] Icider = {"cider"};
		String[] Ipropercider= {"propercider"};
		String[] IGT = {"greenstuff","tonicwater","gin"};
		String[] Ibacardi = {"rum","grenadine","limejuice","gin"};
		_DrinkList.put("hansa", new Drink("hansa",true,30,Ibeer));
		_DrinkList.put("grans", new Drink("grans",true,30,Icider));
		_DrinkList.put("strongbow", new Drink("strongbow",true,30,Ipropercider));
		_DrinkList.put("gt", new Drink("gt",false,2,IGT));
		_DrinkList.put("bacardi_special", new Drink("bacardi_special",false,2,Ibacardi));
	}
	
	public Drink getDrink(String drink) {
		return _DrinkList.get(drink);
	}
}



