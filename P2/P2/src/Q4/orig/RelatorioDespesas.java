package Q4.orig;

import java.util.List;

public class RelatorioDespesas {
	List<Despesa> ld;
	float despesa_total;
	public RelatorioDespesas(List<Despesa> LD, Calculadora calculadora) {
		ld = LD;
		despesa_total = calculadora.CalcularDespesas(LD);
	}
	public String toString() {
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + despesa_total);
		return conteudo;
	}
	
}
