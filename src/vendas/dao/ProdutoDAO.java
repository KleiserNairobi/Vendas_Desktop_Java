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
import vendas.modelo.ProdutoDTO;
import vendas.excecao.TrateExcecao;

public class ProutoDAO implements GenericoDAO<ProdutoDTO> {

    private String sql;
    private PreparedStatement pstm = null;

    @Override
    public void Insira(ProdutoDTO produtoDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "insert into NAIROBI.PRODUTO values(" + "'"
                    + produtoDTO.getCodBarras() + "','"
                    + produtoDTO.getDescricao() + "')"
                    + produtoDTO.getPreco()
                    + comando.execute(sql);

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
    public void Atualize(ProdutoDTO produtoDTO) throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "update NAIROBI.PRODUTO set "
                    + "       DESCRICAO     = " + "'" + produtoDTO.getDescricao() + "'"
                    + "       PRECO         = " + produtoDTO.getPreco() + "'"
                    + " where CODBARRAS      = " + "'" + produtoDTO.getCodBarras() + "'";

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

            sql = "delete from NAIROBI.PRODUTO where CODBARRAS = " + chave;

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

            sql = "delete from NAIROBI.PRODUTO where CODBARRAS = " + "'" + chave + "'";

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
    public List<ProdutoDTO> ListeTodosOsRegistros() throws TrateExcecao {

        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;
        List<ProdutoDTO> listaDeProdutos = new ArrayList<ProdutoDTO>();

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.PRODUTO";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setPreco(rs.getFloat("PRECO"));
                listaDeProdutos.add(produto);
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

        return listaDeProdutos;
    }

    @Override
    public ProdutoDTO BusqueRegistroPorChave(int chave) throws TrateExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProdutoDTO BusqueRegistroPorChave(String chave) throws TrateExcecao {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        FabricaDeConexao conexao = null;
        Statement comando = null;
        ResultSet rs = null;

        try {

            conexao = new FabricaDeConexao();
            comando = FabricaDeConexao.obtenhaInstancia().obtenhaConexao();

            sql = "select * from NAIROBI.PRODUTO where CODBARRAS = " + "'" + chave + "'";
            rs = comando.executeQuery(sql);

            while (rs.next()) {
                produtoDTO.setDescricao(rs.getString("DESCRICAO"));
                produtoDTO.setPreco(rs.getFloat("PRECO"));
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

        return produtoDTO;
    }
}