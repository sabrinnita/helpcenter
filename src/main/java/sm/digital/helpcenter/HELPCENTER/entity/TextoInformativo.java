package sm.digital.helpcenter.HELPCENTER.entity;

public class TextoInformativo {
    private Integer id;
    private String descripcion;
    private Pais pais;
    private Integer prioridad;
    private Integer esTop5;

    public TextoInformativo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getEsTop5() {
        return esTop5;
    }

    public void setEsTop5(Integer esTop5) {
        this.esTop5 = esTop5;
    }
}
