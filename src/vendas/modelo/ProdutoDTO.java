/**
 *
 * @author Regina Arruda
 */
package vendas.modelo;

public class ProdutoDTO {

    private String codBarras;
    private String descricao;
    private float preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String codBarras, String descricao, float preco) {
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}