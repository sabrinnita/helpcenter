package sm.digital.helpcenter.HELPCENTER.service;

import sm.digital.helpcenter.HELPCENTER.json.request.ConsultaRequest;
import sm.digital.helpcenter.HELPCENTER.json.request.OrdenRequest;
import sm.digital.helpcenter.HELPCENTER.json.response.RespuestaResponse;
import sm.digital.helpcenter.HELPCENTER.json.response.StatusResponse;


public interface HelpCenterService {
    public RespuestaResponse buscarContenido(ConsultaRequest consulta);
    public StatusResponse obtenerStatusOrden(OrdenRequest orden);
}
