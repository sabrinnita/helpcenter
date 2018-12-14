package sm.digital.helpcenter.HELPCENTER.json.response;

import sm.digital.helpcenter.HELPCENTER.entity.Respuesta;

import java.util.List;

public class RespuestaResponse {
    List<Respuesta> coincidencias;

    public RespuestaResponse() {
    }

    public RespuestaResponse(List<Respuesta> coincidencias) {
        this.coincidencias = coincidencias;
    }

    public List<Respuesta> getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(List<Respuesta> coincidencias) {
        this.coincidencias = coincidencias;
    }
}