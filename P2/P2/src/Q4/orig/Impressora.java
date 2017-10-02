package Q4.orig;

public class Impressora {
	public void ImprimirDespesa(RelatorioDespesas RD) {
		

		if (RD==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else {
			System.out.println(RD);
		}
}
}
