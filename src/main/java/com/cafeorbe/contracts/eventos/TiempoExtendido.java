package com.cafeorbe.contracts.eventos;

import java.time.Instant;
import java.util.UUID;

/**
 * Publicado por auction cuando una puja válida en la ventana final extiende el tiempo (HU-18, anti-sniping).
 *
 * @param segundosExtendidos cuánto se alargó la subasta con esta extensión
 * @param horaFin            nueva hora de fin
 * @param extension          número de esta extensión (1 para la primera)
 * @param maximoExtensiones  máximo de extensiones que admite la subasta
 */
public record TiempoExtendido(
        UUID subastaId,
        int segundosExtendidos,
        Instant horaFin,
        int extension,
        int maximoExtensiones) {
}
