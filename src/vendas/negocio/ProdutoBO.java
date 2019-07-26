/**
 *
 * @author Regina Arruda
 */
package vendas.negocio;

import java.util.ArrayList;
import java.util.List;
import vendas.dao.ProdutoDAO;
import vendas.modelo.ProdutoDTO;
import vendas.excecao.TrateExcecao;

public class ProdutoBO {

    public void Insira(ProdutoDTO produtoDTO) throws TrateExcecao {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.Insira(produtoDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }               
    }
    
    public void Atualize(ProdutoDTO produtoDTO) throws TrateExcecao {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.Atualize(produtoDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }
    }
    
    public void Exclua(String chave) throws TrateExcecao {
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.Exclua(chave);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }     
        
    }
    
    public List<ProdutoDTO> ListeProdutos() throws TrateExcecao {
        
        List<ProdutoDTO> listaDeProdutos = new ArrayList<ProdutoDTO>();
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            listaDeProdutos = produtoDAO.ListeTodosOsRegistros();
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }

        return listaDeProdutos;
    }
        
}