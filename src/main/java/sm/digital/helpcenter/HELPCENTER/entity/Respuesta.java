package sm.digital.helpcenter.HELPCENTER.entity;

public class Respuesta {
	private String id;
    private String pregunta;
    private String respuesta;

    public Respuesta() {
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
