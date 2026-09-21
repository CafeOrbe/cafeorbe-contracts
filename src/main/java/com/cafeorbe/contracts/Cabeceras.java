package com.cafeorbe.contracts;

/**
 * Cabeceras HTTP con la identidad del usuario, inyectadas por el api-gateway tras validar el token.
 * El nombre viaja codificado como URL (UTF-8) para admitir tildes; el receptor lo decodifica.
 */
public final class Cabeceras {

    public static final String USUARIO_ID = "X-User-Id";
    public static final String USUARIO_NOMBRE = "X-User-Name";
    public static final String USUARIO_ROL = "X-User-Role";

    private Cabeceras() {
    }
}
