package InterpViewer;

import java.io.File;
import java.text.DecimalFormat;

import InterpPresenter.Presentter;

public class Viewer extends AViewer {
	private DecimalFormat formatResult = new DecimalFormat("####.######");
	
	public Viewer() {
	        super();
	    }
	
	public Viewer(AViewer v) {
		    super(v);
	}

	
	// RESPONSABILITY: IMPRIMIR RESULTADOS
    protected void printResult(File file,double value) {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + file);
    	System.out.println("Interp at " + formatResult.format(value) + " ; result = " + formatResult.format(_result));
	}
   

}
