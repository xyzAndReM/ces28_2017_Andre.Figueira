package prx;

public interface DAO {
public Identificavel recuperar(int id);
public void excluir(int id);
public void salvar(Identificavel obj);
}