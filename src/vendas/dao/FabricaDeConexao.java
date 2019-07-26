/**
 * Classe Fábrica de Conexão
 * @author Nairobi
 */

package vendas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaDeConexao {

    private Connection conexao;
    private Statement comando;
    private static final String USUARIO = "system";
    private static final String SENHA = "123456";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String CAMINHO = "jdbc:oracle:thin:@localhost:1521:xe";
    private static FabricaDeConexao instanciaConexao;
    
    public static FabricaDeConexao obtenhaInstancia() {
        if (instanciaConexao == null){
            instanciaConexao = new FabricaDeConexao();
        }
        return instanciaConexao;
    }

    public Statement obtenhaConexao() throws Exception {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(CAMINHO, USUARIO, SENHA);
            comando = conexao.createStatement();
        } catch (ClassNotFoundException ex) {
            throw new Exception("Erro ao tentar conectar com o banco de dados: \n" + ex.getMessage());
        } catch (SQLException sqlex) {
            throw new Exception("Erro ao tentar conectar com o banco de dados: \n" + sqlex.getMessage());
        }
        return comando;
    }      
    
}
