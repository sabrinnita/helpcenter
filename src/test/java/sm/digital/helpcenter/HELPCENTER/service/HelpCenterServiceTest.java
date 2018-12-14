package sm.digital.helpcenter.HELPCENTER.service;

import org.junit.Assert;
import org.junit.Test;
import sm.digital.helpcenter.HELPCENTER.json.request.ConsultaRequest;
import sm.digital.helpcenter.HELPCENTER.json.request.OrdenRequest;
import sm.digital.helpcenter.HELPCENTER.json.response.RespuestaResponse;
import sm.digital.helpcenter.HELPCENTER.json.response.StatusResponse;

public class HelpCenterServiceTest {
    @Test
    public void testBuscarContenido(){
        HelpCenterServiceImplement helpCenterServiceImplement = new HelpCenterServiceImplement();
        ConsultaRequest consultaRequest = new ConsultaRequest();
        consultaRequest.setTexto("jjiji");
        RespuestaResponse respuestaResponse = helpCenterServiceImplement.buscarContenido(consultaRequest);
        Assert.assertNotNull(respuestaResponse);
    }

    /*@Test
    public void testObtenerStatusOrden(){
        HelpCenterServiceImplement helpCenterServiceImplement = new HelpCenterServiceImplement();
        OrdenRequest ordenRequest = new OrdenRequest();
        ordenRequest.setIdOrden("xxx");
        StatusResponse statusResponse = helpCenterServiceImplement.obtenerStatusOrden(ordenRequest);
        Assert.assertNotNull(statusResponse);
    }*/






}
