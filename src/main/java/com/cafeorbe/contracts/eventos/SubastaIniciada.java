package com.cafeorbe.contracts.eventos;

import java.time.Instant;
import java.util.UUID;

/** Publicado por auction cuando el Subastador inicia la subasta y se habilitan las pujas. */
public record SubastaIniciada(
        UUID subastaId,
        String nombre,
        long precioBase,
        long incrementoMinimo,
        int duracionMinutos,
        Instant horaInicio,
        Instant horaFin) {
}
