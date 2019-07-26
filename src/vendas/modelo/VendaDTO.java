/**
 *
 * @author Regina Arruda
 */
package vendas.modelo;

public class VendaDTO {

    private int numero;
    private String data;

    public VendaDTO() {
    }

    public VendaDTO(int numero, String data) {
        this.numero = numero;
        this.data = data;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
