package BD;

public class Cliente {
	Cliente (String CPF) {
		this._CPF = CPF;
	}
	
	private String _CPF;
	
	public String getCPF() {
		return _CPF;
	}
}
