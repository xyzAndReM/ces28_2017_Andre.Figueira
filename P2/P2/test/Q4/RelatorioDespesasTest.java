package Q4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Q4.orig.Calculadora;
import Q4.orig.Despesa;
import Q4.orig.Impressora;
import Q4.orig.RelatorioDespesas;
import Q4.orig.SistemaOperacional;



public class RelatorioDespesasTest {
	
	
	Despesa despesa1 = new Despesa(2);
	Despesa despesa2 = new Despesa(4);
	Despesa despesa3 = new Despesa(6);
	List<Despesa> LD;
	Calculadora calculadora = new Calculadora();
	SistemaOperacional SO = new SistemaOperacional();
	Impressora impressora = SO.getDriverImpressao();
	RelatorioDespesas RD;
	@Test
	public void RelatorioPossui3Despesas() {
		List<Despesa> LD = new ArrayList<Despesa>();
		LD.add(0,despesa1);
		LD.add(1,despesa2);
		LD.add(2,despesa3);
		RD = new RelatorioDespesas(LD,calculadora);
		assertEquals(LD.size(),3);
	}
	
	
	@Test
	public void CalculoDaDespesaTotal() {
		List<Despesa> LD = new ArrayList<Despesa>();
		LD.add(0,despesa1);
		LD.add(1,despesa2);
		LD.add(2,despesa3);
		float despesa_total = calculadora.CalcularDespesas(LD);
		assertEquals(12,despesa_total,0.001);
	}
	
	
	@Test
	public void ImpressaoDoRelatorio() {
		List<Despesa> LD = new ArrayList<Despesa>();
		LD.add(0,despesa1);
		LD.add(1,despesa2);
		LD.add(2,despesa3);
		RD = new RelatorioDespesas(LD,calculadora);
		String relatorio = "Relat�rio de Despesas" +"\n Total das despesas:12.0";
		assertEquals(relatorio,RD.toString());
	}
}