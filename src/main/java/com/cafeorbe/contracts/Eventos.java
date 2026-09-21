package com.cafeorbe.contracts;

/**
 * Nombres del broker y tipos de evento. El tipo de evento se usa también como routing key
 * del exchange topic {@link #EXCHANGE}.
 */
public final class Eventos {

    public static final String EXCHANGE = "cafeorbe.eventos";

    public static final String USUARIO_REGISTRADO = "usuario.registrado";
    public static final String SUBASTA_INICIADA = "subasta.iniciada";
    public static final String PUJA_ACEPTADA = "puja.aceptada";
    public static final String PUJA_RECHAZADA = "puja.rechazada";
    public static final String TRANSMISION_INICIADA = "transmision.iniciada";
    public static final String TRANSMISION_DETENIDA = "transmision.detenida";

    private Eventos() {
    }
}
