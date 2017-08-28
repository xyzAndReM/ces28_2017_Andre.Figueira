
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class Dec2Roman {

	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc. 
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		return conv44(num);
	}
	
	// 1 {} -> null
	public static String conv0(int num) {
		return null; 	// version 0: no test passes.
	}
	
	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}
	
	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {
		
		 String res = "I";

	     if (num > 1)
	        {
	            res += "I";
	        }
	     
	     return res;
	}

	// **************** WHAT YOU HAVE TO DO ****************
	// now write a convX method for each test. 
	// each new convX version must make a new test pass
	// BUT PERFORM ONLY THE MINIMUM CHANGES AT EACH STEP
	// *****************************************************
	
	public static String conv3(int num) {
		String res = "I";
		while (num > 1)
        {
			num -=1;
            res += "I";
        }
     
     return res;
	}
	
	
	public static String conv4(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    	Results.put(1,"I");
    	Results.put(4,"IV");
    	
        if (Results.containsKey(num) )
        {
            return Results.get(num);
        }
        return Results.get(1) + conv4(num - 1);
	}
	
	public static String conv5(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    	Results.put(1,"I");
    	Results.put(4,"IV");
    	Results.put(5,"V");
    	
        if (Results.containsKey(num) )
        {
            return Results.get(num);
        }
        return Results.get(1) + conv5(num - 1);
	}
	
	public static String conv8(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    	Results.put(1,"I");
    	Results.put(4,"IV");
    	Results.put(5,"V");
    	
        if (Results.containsKey(num) )
        {
            return Results.get(num);
        }
        else if (num > 5){
        	num = num - 5;
        	return "V" + conv8(num);
        }
        return Results.get(1) + conv8(num - 1);
	}
	
	public static String conv10(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    	Results.put(1,"I");
    	Results.put(4,"IV");
    	Results.put(5,"V");
    	Results.put(9,"IX");
    	Results.put(10,"X");
    	
        if (Results.containsKey(num) )
        {
            return Results.get(num);
        }
        else if (num > 5){
        	num = num - 5;
        	return "V" + conv10(num);
        }
        return Results.get(1) + conv10(num - 1);
	}
	
	public static String conv14(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    	Results.put(1,"I");
    	Results.put(4,"IV");
    	Results.put(5,"V");
    	Results.put(9,"IX");
    	Results.put(10,"X");
    	
        if (Results.containsKey(num) )
        {
            return Results.get(num);
        }
        else if (num > 5 && num < 10){
        	num = num - 5;
        	return "V" + conv14(num);
        }
        else if (num > 10){
        	num = num - 10;
        	return "X" + conv14(num);
        }
        return Results.get(1) + conv14(num - 1);
	}
	
	public static String conv44(int num) {
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
        Results.put(50, "L");
        Results.put(40, "XL");
        Results.put(10, "X");
        Results.put(9, "IX");
        Results.put(5, "V");
        Results.put(4, "IV");
        Results.put(1, "I");
        String resultado = new String();
        
        for (Map.Entry<Integer, String> entry : Results.entrySet()) {
            Integer k = entry.getKey();
            String value = entry.getValue();
            while(num >= k){
            	resultado += value;
            	num-=k;
            }
            
        }
        return resultado;
        
	}
	
	public static String conv100(int num) {
		TreeMap<Integer, String> Results = new TreeMap<Integer, String>();
		Results.put(100, "C");
		Results.put(90, "XC");
        Results.put(50, "L");
        Results.put(40, "XL");
        Results.put(10, "X");
        Results.put(9, "IX");
        Results.put(5, "V");
        Results.put(4, "IV");
        Results.put(1, "I");
        
        int k =  Results.floorKey(num);
        if ( num == k ) {
           return Results.get(num);
        }
        return Results.get(k) + conv100(num-k);
        
	}
	
	public static String conv100s(int num) {
		TreeMap<Integer, String> Results = new TreeMap<Integer, String>();
		Results.put(500, "D");
	    Results.put(400, "CD");
		Results.put(100, "C");
		Results.put(90, "XC");
        Results.put(50, "L");
        Results.put(40, "XL");
        Results.put(10, "X");
        Results.put(9, "IX");
        Results.put(5, "V");
        Results.put(4, "IV");
        Results.put(1, "I");
        
        int k =  Results.floorKey(num);
        if ( num == k ) {
           return Results.get(num);
        }
        return Results.get(k) + conv100s(num-k);
        
	}
	
	public static String conv2008(int num) {
		TreeMap<Integer, String> Results = new TreeMap<Integer, String>();
		Results.put(1000, "M");
        Results.put(900, "CM");
		Results.put(500, "D");
	    Results.put(400, "CD");
		Results.put(100, "C");
		Results.put(90, "XC");
        Results.put(50, "L");
        Results.put(40, "XL");
        Results.put(10, "X");
        Results.put(9, "IX");
        Results.put(5, "V");
        Results.put(4, "IV");
        Results.put(1, "I");
        
        int k =  Results.floorKey(num);
        if ( num == k ) {
           return Results.get(num);
        }
        return Results.get(k) + conv2008(num-k);
        
	}
	
}

// class Dec2Roman
	
	/*
	/// EXAMPLE OF HOW TO USE A DICTIONARY!
	// example of how to use a dictionary to avoid repetition
	public static String conv4_2(int number)
	    {
	    	LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    	Results.put(1,"I");
	    	Results.put(4,"IV");
	    	
	        if (Results.containsKey(number) )
	        {
	            return Results.get(number);
	        }
	        return Results.get(1) + conv4_2(number - 1);
	    }
	*/


	
		

