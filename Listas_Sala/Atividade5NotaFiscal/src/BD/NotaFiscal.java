package BD;
import java.util.HashMap;

public class NotaFiscal {
	NotaFiscal(VerificadorCPF verif, BDCliente BDC,BDServico BDS, String nomeProduto, int qtd, String CPF) {
		this._IVs = new HashMap<String, ItemVenda>();
		this.add(BDS, nomeProduto, qtd);
		this._cliente = getCliente(verif, BDC, CPF);
	}
	
	NotaFiscal(VerificadorCPF verif, BDCliente BDC,BDServico BDS, HashMap<String, ItemVenda> hash, int qtd, String CPF) {
		this._IVs = hash;
		this._cliente = getCliente(verif, BDC, CPF);
	}
	
	private Cliente getCliente(VerificadorCPF verif, BDCliente BDC, String CPF) {
		if (verif.verifySPC(CPF)) {
			return BDC.getCliente(CPF);
		} else {
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	public void add(BDServico BDS, String nomeProduto, int qtd) {
		if(_IVs.containsKey(nomeProduto)) {
			int oldQtd = this._IVs.get(nomeProduto).getQtd();
			this._IVs.put(nomeProduto, new ItemVenda(BDS, nomeProduto, qtd + oldQtd));
		} else {
			this._IVs.put(nomeProduto, new ItemVenda(BDS, nomeProduto, qtd));
		}
	}
	
	public boolean contains(String nomeProduto) {
		return _IVs.containsKey(nomeProduto);
	}
	
	public void remove(String nomeProduto) {
		if(this._IVs.size() > 1) {
			this._IVs.remove(nomeProduto);
		} else {
			throw new NotaVaziaException();
		}
	}
	
	public double getPreço() {
		double value = 0;
		for(HashMap.Entry<String, ItemVenda> entry : _IVs.entrySet()) {
			value += entry.getValue().getPreço();
		}
		return value;
	}
	
	private HashMap<String, ItemVenda> _IVs;
	private Cliente _cliente;
	private double _valor;
}
