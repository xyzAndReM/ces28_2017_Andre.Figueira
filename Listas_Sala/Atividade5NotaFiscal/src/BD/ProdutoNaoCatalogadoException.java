package BD;

public class ProdutoNaoCatalogadoException extends RuntimeException {
	
	ProdutoNaoCatalogadoException(){
		super("Produto não catalogado!");
	}
	
}
