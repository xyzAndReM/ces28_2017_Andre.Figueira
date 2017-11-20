package InterpV0;

import java.util.Vector;


//RESPONSABILIDADE: EFETIVAMENTE IMPLEMENTAR UM METODO DE INTERPOLACAO
public class CubicSpline implements InterpolationMethod {
    private int i = 1, l = 0, n = 0, lim_left = 0, lim_right = 0;
    private float result = 0;
    private double[][] matrix;
    private Vector<Double> data;
    private boolean flag = false;

    public double calculateResult(double t, Vector<Double> xx, Vector<Double> yy){
        n =  xx.size();
        lim_right = n - 5;
        matrix = new double[n-2][n-1];
        data = new Vector<Double>();

        data.add(2 * (xx.elementAt(i+1) - xx.elementAt(i-1)));
        data.add((xx.elementAt(i+1) - xx.elementAt(i)));

        for (int z = 0; z < (n-4); z++) {
            data.add(0.0);
        }

        data.add(((6 / (xx.elementAt(i+1) - xx.elementAt(i))) * (yy.elementAt(i+1) - yy.elementAt(i))) + ((6 / (xx.elementAt(i)-xx.elementAt(i-1))) * (yy.elementAt(i-1)-yy.elementAt(i))));

        for(i = 2; i < (n-2); i++){
            for (int z = 0; z < lim_left; z++) {
                data.add(0.0);
            }
            lim_left++;

            data.add((xx.elementAt(i)-xx.elementAt(i-1)));
            data.add(2 * (xx.elementAt(i+1) - xx.elementAt(i-1)));
            data.add((xx.elementAt(i+1) - xx.elementAt(i)));

            for (int z = 0; z < lim_right; z++) {
                data.add(0.0);
            }
            lim_right--;

            data.add(((6 / (xx.elementAt(i+1) - xx.elementAt(i))) * (yy.elementAt(i+1) - yy.elementAt(i))) + ((6 / (xx.elementAt(i) - xx.elementAt(i-1))) * (yy.elementAt(i-1)-yy.elementAt(i))));
        }

        for (int z = 0; z < (n-4); z++) {
            data.add(0.0);
        }

        data.add((xx.elementAt(i)-xx.elementAt(i-1)));
        data.add(2 * (xx.elementAt(i+1) - xx.elementAt(i-1)));
        data.add(((6 / (xx.elementAt(i+1) - xx.elementAt(i))) * (yy.elementAt(i+1) - yy.elementAt(i))) + ((6 / (xx.elementAt(i)-xx.elementAt(i-1))) * (yy.elementAt(i-1) - yy.elementAt(i))));

        for(int j = 0; j < i; j++){
            for(int k = 0; k < (i+1); k++){
                matrix[j][k] = data.elementAt(l);
                l++;
            }
        }

        return getFunction(t, xx, yy, Gauss(matrix, (n-2)), n);
    }

    private double[] Gauss(double matrix[][], int n){
        double d2x[] = new double[n+2];
        int i, j, k;
        double pivot, zero;

        for(i = 0; i < n; i++) {
            pivot = matrix[i][i];
            for(j = i; j < (n+1); j++) {
                matrix[i][j] = matrix[i][j]/pivot;
            }

            for(k = 0; k < n; k++) {
                if(k != i) {
                    zero = -matrix[k][i];
                    for(j = i; j < (n+1); j++) {
                        matrix[k][j] = matrix[k][j] + (zero * matrix[i][j]);
                    }
                }
            }
        }

        d2x[0] = 0;
        for (int l = 0; l < (d2x.length - 2); l++) {
            d2x[l+1] = matrix[l][n];
        }
        d2x[n+1] = 0;

        return d2x;
    }

    private float getFunction(double t, Vector<Double> x, Vector<Double> fx, double d2x[], int n){
        i = 1;
        try{
            while(i < n) {
                if ((t  >= x.elementAt(i-1)) && (t <= x.elementAt(i))) {
                    result = (float) ( ((d2x[i-1]/(6*(x.elementAt(i)-x.elementAt(i-1)))) * Math.pow((x.elementAt(i) - t), 3)) +
                            ((d2x[i]/(6*(x.elementAt(i)-x.elementAt(i-1)))) * Math.pow((t - x.elementAt(i-1)), 3)) +
                            ((fx.elementAt(i-1)/(x.elementAt(i)-x.elementAt(i-1)) - ((d2x[i-1]*(x.elementAt(i)-x.elementAt(i-1))) / 6)) * (x.elementAt(i) - t)) +
                            (((fx.elementAt(i)/(x.elementAt(i)-x.elementAt(i-1))) - ((d2x[i]*(x.elementAt(i)-x.elementAt(i-1)))/6)) * (t - x.elementAt(i-1))) );
                    flag = true;
                }
                i++;
            }

            if(!flag)
                System.out.println("Outside range");
        } catch(Exception ex){
            System.out.println(ex);
        }

        return result;
    }

    @Override
    public String toString(){
        return "Cubic Spline";
    }
}