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
import vendas.modelo.ItemVendaDTO;
import vendas.modelo.ProdutoDTO;
import vendas.modelo.VendaDTO;
import vendas.excecao.TrateExcecao;

public class ItemVendaDAO implements GenericoDAO<ItemVendaDTO> {

    private String sql;
    private PreparedStatement pstm = null;

    @Override
    public void Insira(ItemVendaDTO itemVendaDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "insert into NAIROBI.ITEMVENDA values(" + "'"
                    + ItemVendaDTO.getCodBarras() + "','"
                    + ItemVendaDTO.getNumero() +
                    + ItemVendaDTO.getData() +
                    + ItemVendaDTO.getPreco() +;
                   
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
    public void Atualize(ItemVendaDTO itemVendaDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "update NAIROBI.ITEMVENDA set "
                    + "       QUANTIDADE     = " + itemVendaDTO.getQuantidade() +
                    + "       DATA     = " + itemVendaDTO.getData() +
                    + " where CODBARRAS, NUMERO      = " + "'" + itemVendaDTO.getCodBarras()+ "'" AND itemVendaDTO.getNumero();

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

            sql = "delete from NAIROBI.ITEMVENDA where CODBARRAS, NUMERO = " + chave;

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

            sql = "delete from NAIROBI.ITEMVENDA where CODBARRAS, NUMERO = " + "'" + chave + "'";

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
    public List<ItemVendaDTO> ListeTodosOsRegistros() throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;
        List<ItemVendaDTO> listaDeItemVendas = new ArrayList<ItemVendaDTO>();

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.ITEMVENDA";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                ItemVendaDTO itemVenda = new ItemVendaDTO();
                itemVenda.setData(rs.getString("CODBARRAS"));
                itemVenda.setNumero(rs.getInt("NUMERO"));
                itemVenda.setQuantidade(rs.getFloat("QUANTIDADE"));
                itemVenda.setNumero(rs.getFloat("PRECO"));
                listaDeItemVendas.add(itemVenda);
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

        return listaDeItemVendas;
    }

    @Override
    public ItemVendaDTO BusqueRegistroPorChave(int chave) throws TrateExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ItemVendaDTO BusqueRegistroPorChave(String chave) throws TrateExcecao {

        ItemVendaDTO vendaDTO = new ItemVendaDTO();
        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.ITEMVENDA where CODBARRAS, NUMERO = " + "'" + chave + "'";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                itemVendaDTO.setCodBarras(rs.getString("CODBARRAS"));
                itemVendaDTO.setNumero(rs.getInt("NUMERO"));
                itemVendaDTO.setQuantidade(rs.getFloat("Quantidade"));
                itemVendaDTO.setPreco(rs.getFloat("PRECO"));
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

        return ItemVendaDTO;
    }
}