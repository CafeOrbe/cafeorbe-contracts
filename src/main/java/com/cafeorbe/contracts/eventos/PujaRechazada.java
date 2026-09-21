package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/** Publicado por auction cuando una puja no pasa la validación. Solo interesa a quien pujó. */
public record PujaRechazada(
        UUID subastaId,
        UUID usuarioId,
        long montoIntentado,
        String motivo,
        String mensaje) {
}
