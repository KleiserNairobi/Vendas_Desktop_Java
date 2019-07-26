/**
 * Interface genérica para DAO
 * @author Nairobi
 */

package vendas.dao;
import java.util.List;
import vendas.excecao.TrateExcecao;

public interface GenericoDAO<T> {
    void Insira(T obj) throws TrateExcecao;
    void Atualize(T Obj) throws TrateExcecao;
    void Exclua(int chave) throws TrateExcecao;
    void Exclua(String chave) throws TrateExcecao;
    List<T> ListeTodosOsRegistros() throws TrateExcecao;
    T BusqueRegistroPorChave(int chave) throws TrateExcecao;   
    T BusqueRegistroPorChave(String chave) throws TrateExcecao;
}
