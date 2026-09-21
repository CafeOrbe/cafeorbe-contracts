package com.cafeorbe.contracts.eventos;

import java.time.Instant;
import java.util.UUID;

/** Publicado por auction cuando una puja pasa la validación: hay nuevo líder y nuevo precio. */
public record PujaAceptada(
        UUID subastaId,
        UUID pujaId,
        UUID usuarioId,
        String usuarioNombre,
        long monto,
        int cantidadPujas,
        long siguienteMinimo,
        Instant ocurridaEn) {
}
