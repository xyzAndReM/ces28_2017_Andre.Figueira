package InterpViewer;

import java.io.File;
import java.text.DecimalFormat;

public class Viewer2 extends AViewer {

	private DecimalFormat formatResult = new DecimalFormat("####.######");
	
	public Viewer2() {
        super();
    }

    public Viewer2(AViewer v) {
	    super(v);
    }
	
	
	protected void printResult(File file, double value) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("DataFile: " + file);
    	System.out.println("Interp at " + formatResult.format(value) + " ; result = " + formatResult.format(_result));
	}

}
