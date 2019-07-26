/**
 *
 * @author Nairobi
 */
package vendas.dao;

import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.modelo.ClienteDTO;
import vendas.excecao.TrateExcecao;

public class ClienteDAO implements GenericoDAO<ClienteDTO> {

    private String sql;
    private PreparedStatement pstm = null;

    @Override
    public void Insira(ClienteDTO clienteDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "insert into NAIROBI.CLIENTE values(" + "'"
                    + clienteDTO.getCpf() + "','"
                    + clienteDTO.getNome() + "')";
            comando.execute(sql);

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }
    }

    @Override
    public void Atualize(ClienteDTO clienteDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "update NAIROBI.CLIENTE set "
                    + "       NOME     = " + "'" + clienteDTO.getNome() + "'"
                    + " where CPF      = " + "'" + clienteDTO.getCpf() + "'";

            comando.execute(sql);

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }

    }

    @Override
    public void Exclua(int chave) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "delete from NAIROBI.CLIENTE where CPF = " + chave;

            comando.execute(sql);

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }

    }

    @Override
    public void Exclua(String chave) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "delete from NAIROBI.CLIENTE where CPF = " + "'" + chave + "'";

            comando.execute(sql);

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }

    }

    @Override
    public List<ClienteDTO> ListeTodosOsRegistros() throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;
        List<ClienteDTO> listaDeClientes = new ArrayList<ClienteDTO>();

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.CLIENTE";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCpf(rs.getString("CPF"));
                cliente.setNome(rs.getString("NOME"));
                listaDeClientes.add(cliente);
            }

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                rs.close();
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }

        return listaDeClientes;
    }

    @Override
    public ClienteDTO BusqueRegistroPorChave(int chave) throws TrateExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ClienteDTO BusqueRegistroPorChave(String chave) throws TrateExcecao {

        ClienteDTO clienteDTO = new ClienteDTO();
        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.CLIENTE where CPF = " + "'" + chave + "'";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                clienteDTO.setCpf(rs.getString("CPF"));
                clienteDTO.setNome(rs.getString("NOME"));
            }

        } catch (Exception ex) {
            throw new TrateExcecao(ex.getMessage(), ex);
        } finally {
            try {
                rs.close();
                comando.close();
            } catch (SQLException ex) {
                throw new TrateExcecao(ex.getMessage(), ex);
            }
        }

        return clienteDTO;
    }
}