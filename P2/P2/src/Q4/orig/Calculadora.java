package Q4.orig;

import java.util.List;

public class Calculadora {
	
	public float CalcularDespesas(List<Despesa> LD) {
		float totalDespesa = 0.0f;
		List<Despesa> ListaDespesas = LD;
		for (Despesa D : ListaDespesas) {
			totalDespesa += D.getDespesa();
		}
		return totalDespesa;
	
	}
}
