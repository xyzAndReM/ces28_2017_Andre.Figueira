package BD;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class NotaFiscalTest {
	
	@Mock
	private BDCliente BDC;
	
	@Mock
	private BDServico BDS;
	
	@Mock
	private VerificadorCPF verif;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		String itemVenda = "777";
	}
	
	// ************ a)
	@Test
	public void CadastroClienteComCPFLimpoPassa() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// verifica se chamou o validador de CPF
		verify(verif, times(1)).verifySPC("777");
	}
	
	// ************ c)
	@Test(expected = IllegalArgumentException.class)
	public void CadastroClienteComCPFSujoFalha() {
		Mockito.when(verif.verifySPC("555")).thenReturn(false);
		Mockito.when(BDC.getCliente("555")).thenReturn(new Cliente("555"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "555");
		// verifica se chamou o validador de CPF
		verify(verif, times(1)).verifySPC("555");
	}
	
	// verifica se o método contains funciona:
	@Test
	public void VerificaoMétodoContains() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// nenhuma "Tartaruga" foi adicionada:
		assertFalse(NF.contains("Tartaruga"));
		// "Abajour" foi adicionado:
		assertTrue(NF.contains("Abajour"));
	}
	
	// **************** d)
	@Test
	public void AdicionaItems() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// adiciona Buzzlightyear
		Mockito.when(BDS.getItem("Buzzlightyear")).thenReturn(new Produto("Buzzlightyear", 11.10));
		NF.add(BDS, "Buzzlightyear", 2);
		// verifica os dois ítems da nota fiscal:
		assertTrue(NF.contains("Buzzlightyear"));
		assertTrue(NF.contains("Abajour"));
	}
	
	@Test
	public void VerificaValorDaNota() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 1, "777");
		// adiciona Buzzlightyear
		Mockito.when(BDS.getItem("Buzzlightyear")).thenReturn(new Produto("Buzzlightyear", 11.10));
		NF.add(BDS, "Buzzlightyear", 2);
		assertEquals(50.19, NF.getPreço(), 0.001);
	}
	
	@Test
	public void RemoveItems() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// adiciona Buzzlightyear
		Mockito.when(BDS.getItem("Buzzlightyear")).thenReturn(new Produto("Buzzlightyear", 11.10));
		NF.add(BDS, "Buzzlightyear", 2);
		assertTrue(NF.contains("Buzzlightyear"));
		// remove e verifica se o Item "Buzzlightyear" foi removido:
		NF.remove("Buzzlightyear");
		assertFalse(NF.contains("Buzzlightyear"));
	}
	
	// **************** e)
	@Test
	public void TrocaUmItem() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// adiciona Buzzlightyear
		Mockito.when(BDS.getItem("Buzzlightyear")).thenReturn(new Produto("Buzzlightyear", 11.10));
		NF.add(BDS, "Buzzlightyear", 2);
		NF.remove("Abajour");
		assertEquals(22.20, NF.getPreço(), 0.001);
	}
	
	// ************* f)
	@Test(expected = ProdutoNaoCatalogadoException.class)
	public void BuscarProdutoNaoCatalogadoNoBDSgeraErro() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// tenta adicionar Banana, que não consta no BDServico
		Mockito.when(BDS.getItem("Banana")).thenThrow(new ProdutoNaoCatalogadoException());
		NF.add(BDS, "Banana", 2);
		assertFalse(NF.contains("Banana"));
	}
	
	// ************ h)
	@Test(expected = NotaVaziaException.class)
	public void RemoverAtéEsvaziarANotaGeraErro() {
		Mockito.when(verif.verifySPC("777")).thenReturn(true);
		Mockito.when(BDC.getCliente("777")).thenReturn(new Cliente("777"));
		// abajour
		Mockito.when(BDS.getItem("Abajour")).thenReturn(new Produto("Abajour", 27.99));
		NotaFiscal NF = new NotaFiscal(verif, BDC, BDS, "Abajour", 7, "777");
		// tenta remover o único ítem da nota:
		NF.remove("Abajour");
	}
}
