/**
 *
 * @author Regina Arruda
 */
package vendas.negocio;

import java.util.ArrayList;
import java.util.List;
import vendas.dao.ClienteDAO;
import vendas.modelo.ClienteDTO;
import vendas.excecao.TrateExcecao;

public class ClienteBO {

    public void Insira(ClienteDTO clienteDTO) throws TrateExcecao {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.Insira(clienteDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }               
    }
    
    public void Atualize(ClienteDTO clienteDTO) throws TrateExcecao {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.Atualize(clienteDTO);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }
    }
    
    public void Exclua(String chave) throws TrateExcecao {
        
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.Exclua(chave);
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }     
        
    }
    
    public List<ClienteDTO> ListeClientes() throws TrateExcecao {
        
        List<ClienteDTO> listaDePessoas = new ArrayList<ClienteDTO>();
        
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            listaDePessoas = clienteDAO.ListeTodosOsRegistros();
        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        }

        return listaDePessoas;
    }
        
}
