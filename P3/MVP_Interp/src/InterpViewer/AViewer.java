package InterpViewer;

import java.io.File;

import InterpPresenter.Presentter;
import InterpV0.InterpolationMethod;

public abstract class AViewer {
	protected Presentter _presentter;
	protected double _result;
	
	/**
	 * Há dois construtores, se nenhum parâmetro é passado um novo viewer
	 * é criado com um novo presenter e um novo model. Se um viewer é passado como
	 * argumento, este novo viewer possuirá como presenter e model os mesmos
	 * do argumento passado no construtor
	 */
	public AViewer() {
		this._presentter = new Presentter();
	}
	
	public AViewer(AViewer v) {
		this._presentter = v.getPresentter();
	}
	
	private Presentter getPresentter() {
    	return this._presentter;
    }
	
	// RESPONSABILITY: IMPRIMIR RESULTADOS
    abstract protected void printResult(File file,double value);
    
    public void interpolate(double value,File file, String method) {
    	_result = _presentter.calculate(value, file, method);
    	printResult(file,value);
    }
    
    public void interpolate(double value,File file, InterpolationMethod IM) {
    	_result = _presentter.calculate(value, file, IM);
    	printResult(file,value);
    }
    
    public void addAlgorithm(InterpolationMethod IM, String name) {
    	_presentter.addAlgorithm(IM,name);
    }
    
    
    
}