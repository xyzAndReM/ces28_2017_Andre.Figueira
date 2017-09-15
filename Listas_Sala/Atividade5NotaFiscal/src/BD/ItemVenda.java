package BD;

public class ItemVenda {
	ItemVenda(BDServico BDS, String nomeProduto, int qtd) {
		this._produto = BDS.getItem(nomeProduto);
		this._qtd = qtd;
	}
	
	public double getPreço() {
		return _produto.getPreço()*((double)_qtd);
	}
	
	public int getQtd() {
		return this._qtd;
	}
	
	private Produto _produto;
	private int _qtd;
}
