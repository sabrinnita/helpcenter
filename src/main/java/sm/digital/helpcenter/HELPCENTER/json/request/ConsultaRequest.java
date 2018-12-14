package sm.digital.helpcenter.HELPCENTER.json.request;

public class ConsultaRequest {
    private String texto;

    public ConsultaRequest(String texto) {
        this.texto = texto;
    }

    public ConsultaRequest() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
