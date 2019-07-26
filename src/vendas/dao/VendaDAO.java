/**
 *
 * @author Regina Arruda
 */
package vendas.dao;

import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.modelo.VendaDTO;
import vendas.excecao.TrateExcecao;

public class VendaDAO implements GenericoDAO<VendaDTO> {

    private String sql;
    private PreparedStatement pstm = null;

    @Override
    public void Insira(VendaDTO vendaDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "insert into NAIROBI.VENDA values(" + "'"
                    + vendaDTO.getData() + "','"
                    + vendaDTO.getNumero() +
                   
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
    public void Atualize(VendaDTO vendaDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "update NAIROBI.VENDA set "
                    + "       DATA     = " + "'" + vendaDTO.getData() + "'"
                    + " where NUMERO      = " + "'" + vendaDTO.getNumero() + "'";

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

            sql = "delete from NAIROBI.VENDA where NUMERO = " + chave;

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

            sql = "delete from NAIROBI.VENDA where NUMERO = " + "'" + chave + "'";

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
    public List<VendaDTO> ListeTodosOsRegistros() throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;
        List<VendaDTO> listaDeVendas = new ArrayList<VendaDTO>();

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.VENDA";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                VendaDTO venda = new VendaDTO();
                venda.setData(rs.getString("DATA"));
                venda.setNumero(rs.getInt("NUMERO"));
                listaDeVendas.add(venda);
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

        return listaDeVendas;
    }

    @Override
    public VendaDTO BusqueRegistroPorChave(int chave) throws TrateExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public VendaDTO BusqueRegistroPorChave(String chave) throws TrateExcecao {

        VendaDTO vendaDTO = new VendaDTO();
        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.VENDA where NUMERO = " + "'" + chave + "'";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                vendaDTO.setData(rs.getString("DATA"));
                vendaDTO.setNumero(rs.getInt("NUMERO"));
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

        return vendaDTO;
    }
}
