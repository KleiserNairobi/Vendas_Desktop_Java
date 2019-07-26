/**
 *
 * @author Regina Arruda
 */
package vendas.negocio;

import java.util.ArrayList;
import java.util.List;
import vendas.dao.ItemVendaDAO;
import vendas.modelo.ItemVendaDTO;
import vendas.excecao.TrateExcecao;

public class ItemVendaBO {

    public void Insira(ItemVendaDTO itemVendaDTO) throws TrateExcecao {
        try {
            ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
            itemVendaDAO.Insira(itemVendaDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }               
    }
    
    public void Atualize(ItemVendaDTO itemVendaDTO) throws TrateExcecao {
        try {
            ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
            itemVendaDAO.Atualize(itemVendaDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }
    }
    
    public void Exclua(String chave) throws TrateExcecao {
        
        try {
            ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
            itemVendaDAO.Exclua(chave);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }     
        
    }
    
    public List<ItemVendaDTO> ListeItemVendas() throws TrateExcecao {
        
        List<ItemVendaDTO> listaDeItemVendas = new ArrayList<ItemVendaDTO>();
        
        try {
            ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
            listaDeItemVendas = itemVendaDAO.ListeTodosOsRegistros();
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }

        return listaDeItemVendas;
    }
        
}
