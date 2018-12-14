package sm.digital.helpcenter.HELPCENTER.json.response;

public class StatusResponse {

    private String statusOrden;

    public StatusResponse() {}

    public StatusResponse(String statusOrden) {
        this.statusOrden = statusOrden;
    }

    public String getStatusOrden() {
        return statusOrden;
    }

    public void setStatusOrden(String statusOrden) {
        this.statusOrden = statusOrden;
    }



}
