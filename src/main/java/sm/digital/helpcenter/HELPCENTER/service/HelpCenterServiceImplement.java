package sm.digital.helpcenter.HELPCENTER.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sm.digital.helpcenter.HELPCENTER.constantes.StatusVtex;
import sm.digital.helpcenter.HELPCENTER.entity.Respuesta;
import sm.digital.helpcenter.HELPCENTER.json.request.ConsultaRequest;
import sm.digital.helpcenter.HELPCENTER.json.request.OrdenRequest;
import sm.digital.helpcenter.HELPCENTER.json.response.RespuestaResponse;
import sm.digital.helpcenter.HELPCENTER.json.response.StatusResponse;
import sm.digital.helpcenter.HELPCENTER.mapper.HelpCenterMapper;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelpCenterServiceImplement implements HelpCenterService {

    @Value("${token}")
    private String token;
	
	private List<Respuesta> conincidencias = new ArrayList<>();

	@Autowired
	private HelpCenterMapper helpCenterMapper;
	
    @Override
    public RespuestaResponse buscarContenido(ConsultaRequest consulta) {
        List<Respuesta> conincidencias = new ArrayList<>();
        RespuestaResponse respuestaResponse = new RespuestaResponse();
        
        /*String[] preguntas = {"¿Puedo cancelar o cambiar mi pedido?",
                              "¿Qué hago si mi producto llega dañado?",
                              "¿Qué hago si no recibí todos los productos que ordené?",
                              "¿Qué hago si no encuentro un producto?",
                              "¿Cómo hago válida una garantía?"};
        String[] respuestas = {"Sí puedes hacerlo. Tienes 5 días desde el momento que haces tú compra para comunicarte con nuestra línea de servicio al cliente y cancelar tu pedido. Para mayor información consulta nuestros Términos y Condiciones. Para los productos de mercado y aseo (Personal y hogar) puedes cancelar tu pedido hasta el momento de la entrega.",
                               "Si tu producto no llegó en condiciones óptimas, no lo recibas del transportador, deja la novedad por escrito en la guía de entrega y comunícate con nuestras líneas de atención en Bogotá 348 9898 o al 018000 120 320 nivel nacional. Si tu producto no funciona como tú esperabas, revisa por favor el manual de instrucciones. Recuerda que hay ciertos productos que requieren armado especializado. Si después de revisar el manual de instrucciones, tu producto aún no funciona, comunícate con nosotros para que te indiquemos como hacer uso de tu garantía. Para mayor información revisa nuestros Términos y Condiciones.",
                               "Si no recibiste todos los productos en un mismo envío no te preocupes, ya que pueden manejar diferentes tiempos de entrega. Recuerda que puedes revisar en el correo de confirmación de estos tiempos. Si tienes alguna duda al respecto puedes comunicarte con nuestras líneas de atención Bogotá 348 9898 y a la 018000 120 320 a nivel nacional",
                               "Si has agotado todas las posibilidades de búsqueda del producto que quieres y no lo encuentras, podrías encontrar referencias similares. Si tienes dudas, comunícate con nuestra línea de servicio al cliente 348 9898 en Bogotá y 018000 120320 en el resto del país.",
                               "En caso de falla de fabricación del producto es requisito indispensable que este sea revisado por el Centro de Servicios Autorizado establecido por la marca. Éste realiza el diagnóstico respectivo y con base en él decide si se cambia la parte defectuosa o si entregará la carta para el cambio total o se niega la garantía. Recuerda que para el trámite de tu garantía debes presentar: la tirilla de compra impresa que enviamos a tu correo electrónico o fotocopia de la cédula de ciudadanía del comprador. Toda solicitud se atenderá en un tiempo máximo de quince (15) días hábiles siguientes a la recepción de la solicitud de garantía. Si el bien debe ser reparado y para ello se requiere de un proceso de cambio de la o las piezas defectuosas este se realizará dentro de los treinta (30) días hábiles contados a partir del día siguiente a la recepción de la solicitud. La corrección de la falla es gratuita y en caso de que se repita, tendrás la opción de solicitar el cambio del bien, efectuar una nueva corrección o solicitar la devolución del dinero. Si el Centro de Servicios Autorizado certifica que efectivamente el producto tiene problemas o defectos de fábrica, la garantía del nuevo producto inicia a partir de la fecha en que sea recibido por el cliente y hasta el tiempo establecido."};*/
       
        String[] parts = consulta.getTexto().split(" ");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        //HttpEntity<RespuestaResponse> httpEntity  = new HttpEntity<>(httpHeaders);
        System.out.println("Token: " + token);
        ResponseEntity<List<Respuesta>> response = restTemplate.exchange("http://ec2-54-193-28-122.us-west-1.compute.amazonaws.com/api/peru/wong/centro_de_ayuda?token="+token, HttpMethod.GET, null, new ParameterizedTypeReference<List<Respuesta>>(){});
        List<Respuesta> dataCms = (List<Respuesta>) response.getBody();
        for (String parte : parts) {
        	if (!parte.isEmpty())
	        for(Respuesta preguntaCms : dataCms) {	        	
	        	boolean encontrado = cleanString(preguntaCms.getPregunta()).toUpperCase().contains(cleanString(parte).toUpperCase());
	        	if (encontrado) {
	        		validarAgrego(preguntaCms, conincidencias);
	        	}	        	
	        }
        }
        respuestaResponse.setCoincidencias(conincidencias);
        /*
        if(!consulta.getTexto().isEmpty()){
            int posicion = 0;
            Respuesta respuesta;
            for (String p : preguntas) {
                boolean encontrado = cleanString(p).toUpperCase().contains(cleanString(consulta.getTexto()).toUpperCase());
                if (encontrado) {
                    respuesta = new Respuesta();
                    respuesta.setPregunta(p);
                    respuesta.setRespuesta(respuestas[posicion]);
                    conincidencias.add(respuesta);
                }
                posicion++;
            }
        }
        respuestaResponse.setCoincidencias(conincidencias);*/
        return respuestaResponse;
    }

    @Override
    public StatusResponse obtenerStatusOrden(OrdenRequest orden) {
        Integer status = helpCenterMapper.statusOrden(orden.getIdOrden());
        String statusTraducido = "";

        if(status == StatusVtex.PENDIENTE_PICKING || status == StatusVtex.PENDIENTE_RE_PICKING ||
                status == StatusVtex.EN_PICKING || status == StatusVtex.PENDIENTE_FINALIZAR_PICKING ||
                status == StatusVtex.PRE_PICKING) {
            statusTraducido = "ORDEN RECIBIDA";
        }else if(status == StatusVtex.FINALIZADO_PICKING || status == StatusVtex.PICKEADO_POR_FACTURAR){
            statusTraducido = "ORDEN CONFECCIONADA";
        }else if(status == StatusVtex.FACTURADO || status == StatusVtex.LISTO_PARA_ENVIAR ||
                status == StatusVtex.LISTO_PARA_RETIRAR || status == StatusVtex.ESPERANDO_LOGISTICA_EXTERNA){
            statusTraducido = "DESPACHADO";
        }else if(status == StatusVtex.DESPACHADO) {
            statusTraducido = "EN CAMINO";
        }else if(status == StatusVtex.ANULADO || status == StatusVtex.ANULACION_AUTOMATICA_PENDIENTE ||
                status == StatusVtex.ANULACION_CONFIRMADA || status == StatusVtex.CANCELADO ||
                status == StatusVtex.PRE_CANCELADO) {
            statusTraducido = "ANULADO";
        }else if(status == StatusVtex.ENTREGADO){
            statusTraducido = "ENTREGADO";
        }else{
            statusTraducido = "OTRO";
        }
        StatusResponse statusResponse = new StatusResponse(statusTraducido);
        return statusResponse;
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

	public static void validarAgrego(Respuesta preguntaCms, List<Respuesta> coincidencias) {
		Integer encontrado = 0;
			for(Respuesta coincidencia : coincidencias) {
				if(coincidencia.getId() == preguntaCms.getId()) {
					encontrado = 1;
					break;
				}
			}
			if (encontrado==0) {
				coincidencias.add(preguntaCms);
			}
	}
}
