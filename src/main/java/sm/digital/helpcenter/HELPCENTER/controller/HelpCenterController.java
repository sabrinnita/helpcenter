package sm.digital.helpcenter.HELPCENTER.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sm.digital.helpcenter.HELPCENTER.json.request.ConsultaRequest;
import sm.digital.helpcenter.HELPCENTER.json.request.OrdenRequest;
import sm.digital.helpcenter.HELPCENTER.json.response.RespuestaResponse;
import sm.digital.helpcenter.HELPCENTER.json.response.StatusResponse;
import sm.digital.helpcenter.HELPCENTER.service.HelpCenterService;


@RestController
public class HelpCenterController {

    @Autowired
    HelpCenterService helpCenterService;

    @PostMapping(value = "/obtenerPorPalabra")
    @ResponseBody
    public RespuestaResponse busqueda(@RequestBody ConsultaRequest consulta) {
       //System.out.println("getTexto->"+consulta.getTexto());
       return helpCenterService.buscarContenido(consulta);
    }

    @GetMapping(value = "/obtenerInfoOrden/{orden}")
    public StatusResponse obtenerInfoOrden(@PathVariable("orden") String orden) {
        OrdenRequest ordenRequest = new OrdenRequest(orden);
        return helpCenterService.obtenerStatusOrden(ordenRequest);
    }
    


}

