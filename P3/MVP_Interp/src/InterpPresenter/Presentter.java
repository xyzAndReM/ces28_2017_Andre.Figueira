package InterpPresenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import InterpModel.Model;
import InterpV0.InterpolationMethod;


public class Presentter {
	
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private File _file;
    private Vector<Double> x, y;
	private Model _model;

	
    public Presentter() {
    	_model = new Model();
    }
	// RESPONSABILITY: LER ARQUIVO DE DADOS
		private void buildDataPoints(File file) {
	        if(file == null)
	           return;
	        else _file = file;
	        x = new Vector<Double>();
	        y = new Vector<Double>();
	        try {
	            input = new FileReader(_file);
			    /* Filter FileReader through a Buffered read to read a line at a time */
	            bufRead = new BufferedReader(input);
	            // Read first line
	            String line = bufRead.readLine();
	            // Read through file one line at time.
	            while (line != null){
	                xy = new StringTokenizer(line, "\t ");
	                while(xy.hasMoreTokens()) {
	                    x.addElement(Double.parseDouble(xy.nextToken()));
	                    y.addElement(Double.parseDouble(xy.nextToken()));
	                }
	                line = bufRead.readLine();
	            }
	            bufRead.close();
	        } catch (IOException e) { // If another exception is generated, print a stack trace
	            e.printStackTrace();
	        }
	    
	    }
		public double calculate(double value, File file, String method) {
        	buildDataPoints(file);
        	return( _model.calculateResult(value, x, y, method) );
        }
		
		public double calculate(double value, File file, InterpolationMethod IM) {
        	buildDataPoints(file);
        	return( _model.calculateResult(value, x, y, IM) );
        }
		
		public void addAlgorithm(InterpolationMethod IM, String name) {
	    	_model.addAlgorithm(IM,name);
	    }
		
		
		
}
