package InterpModel;


import java.util.Hashtable;
import java.util.Vector;

import InterpV0.CubicSpline;
import InterpV0.InterpolationMethod;
import InterpV0.Lagrange;

public class  Model {
	private InterpolationMethod interpolationModel;
	
	private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final String DEFAULT_METHOD = CS_METHOD;
    private double result;
    private Hashtable<String, InterpolationMethod> _methods;
    
    
	public void  setModel(InterpolationMethod NewMethod) {
		interpolationModel = NewMethod;
	}
	
public Model() {
	bind();
}
public void bind() {
	_methods = new Hashtable<String, InterpolationMethod>();
	_methods.put(L_METHOD, new Lagrange());
	_methods.put(CS_METHOD, new CubicSpline() );
    interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
    }
	
	
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod() { return interpolationModel; }
    public InterpolationMethod getMethod(String method) {
        interpolationModel = _methods.get(method);

        return interpolationModel;
    }//Para adicionar outro método de interpolação basta acrescentar um caso neste switch.
    
    
 // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public double calculateResult(double value,Vector<Double> x , Vector<Double> y, String method) {
        if(method != null) {
        	getMethod(method);
        }
        if(getMethod() != null) {
            result = getMethod().calculateResult(value, x, y);
            //printResult();
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
        return result;
    }
    
    public double calculateResult(double value,Vector<Double> x , Vector<Double> y, InterpolationMethod IM) {
        if(IM != null) {
            result = getMethod().calculateResult(value, x, y);
            //printResult();
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
        return result;
    }
    
    public void addAlgorithm(InterpolationMethod IM, String name) {
    	_methods.put(name, IM);
    }
	
	
	
	
}
