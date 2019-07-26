/**
 *
 * @author Regina Arruda
 */
package vendas.modelo;
import vendas.modelo.VendaDTO;
import vendas.modelo.ProdutoDTO;

public class ItemVendaDTO {
    private Produto produto;
    private Venda venda;
    private float quantidade;
    private float preco;

    public ItemVendaDTO() {
    }

    public ItemVendaDTO(Produto produto, Venda venda, float quantidade, float preco) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    private static class Produto {

        public Produto() {
        }
    }

    private static class Venda {

        public Venda() {
        }
    }
}