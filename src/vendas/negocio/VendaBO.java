/**
 *
 * @author Regina Arruda
 */
package vendas.negocio;

import java.util.ArrayList;
import java.util.List;
import vendas.dao.VendaDAO;
import vendas.modelo.VendaDTO;
import vendas.excecao.TrateExcecao;

public class VendaBO {

    public void Insira(VendaDTO vendaDTO) throws TrateExcecao {
        try {
            VendaDAO vendaDAO = new VendaDAO();
            vendaDAO.Insira(vendaDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }               
    }
    
    public void Atualize(VendaDTO vendaDTO) throws TrateExcecao {
        try {
            VendaDAO vendaDAO = new VendaDAO();
            vendaDAO.Atualize(vendaDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }
    }
    
    public void Exclua(String chave) throws TrateExcecao {
        
        try {
            VendaDAO vendaDAO = new VendaDAO();
            vendaDAO.Exclua(chave);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }     
        
    }
    
    public List<VendaDTO> ListeVendas() throws TrateExcecao {
        
        List<VendaDTO> listaDeVendas = new ArrayList<VendaDTO>();
        
        try {
            VendaDAO vendaDAO = new VendaDAO();
            listaDeVendas = vendaDAO.ListeTodosOsRegistros();
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }

        return listaDeVendas;
    }
        
}
