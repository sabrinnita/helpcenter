package sm.digital.helpcenter.HELPCENTER.constantes;

public abstract class StatusVtex {

    //ORDEN RECIBIDA
    public static Integer PENDIENTE_PICKING = 10;
    public static Integer PENDIENTE_RE_PICKING = 11;
    public static Integer EN_PICKING = 20;
    public static Integer PENDIENTE_FINALIZAR_PICKING = 21;
    public static Integer PRE_PICKING = 25;

    //ORDEN CONFECCIONADA
    public static Integer FINALIZADO_PICKING = 22;
    public static Integer PICKEADO_POR_FACTURAR = 30;


    //DESPACHADO
    public static Integer FACTURADO = 40;
    public static Integer LISTO_PARA_ENVIAR = 60;
    public static Integer LISTO_PARA_RETIRAR = 65;
    public static Integer ESPERANDO_LOGISTICA_EXTERNA = 66;

    //EN CAMINO
    public static Integer DESPACHADO = 70;

    //ANULADO
    public static Integer ANULADO = 100;
    public static Integer ANULACION_AUTOMATICA_PENDIENTE = 105;
    public static Integer ANULACION_CONFIRMADA = 110;
    public static Integer CANCELADO = 125;
    public static Integer PRE_CANCELADO = 35;

    //ENTREGADO
    public static Integer ENTREGADO = 90;
    public static Integer LIQUIDADO = 95;

    //OTROS
    public static Integer A_REPROGRAMAR_ENTREGA = 80;
    public static Integer CANCELACION_PENDIENTE = 120;
    public static Integer DEVOLUCION_PARCIAL = 130;
    public static Integer DEVOLUCION_TOTAL = 135;
    public static Integer AUDITORIA_RECHAZADA = 6;
    public static Integer PENDIENTE_AUDITORIA = 5;
    public static Integer A_RECUPERAR = 50;
}
