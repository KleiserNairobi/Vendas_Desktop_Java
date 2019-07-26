/**
 *
 * @author Nairobi
 */

package vendas.excecao;


public class TrateExcecao extends Exception {
    
    public TrateExcecao(String msg) {
        super(msg);
    }
    
    public TrateExcecao(String msg, Exception ex) {
        super(msg, ex);
    }
    
}
