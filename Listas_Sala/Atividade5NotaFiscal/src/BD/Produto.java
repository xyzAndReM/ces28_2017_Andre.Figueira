package BD;

public class Produto {
	Produto(String nome, double preço) {
		this._nome = nome;
		this._preço = preço;
	}

	public double getPreço() {
		return this._preço;
	}
	
	private String _nome;
	private double _preço;
}
