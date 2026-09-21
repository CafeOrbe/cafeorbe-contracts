package com.cafeorbe.contracts;

import java.time.Instant;
import java.util.UUID;

/**
 * Sobre común de todos los eventos publicados en el broker.
 *
 * @param eventId     identificador único del evento; los consumidores lo usan para ser idempotentes
 * @param tipo        tipo de evento (ver {@link Eventos})
 * @param version     versión del esquema de {@code datos}
 * @param ocurridoEn  instante en que ocurrió el hecho
 * @param datos       carga útil del evento
 */
public record EventoEnvelope<T>(UUID eventId, String tipo, int version, Instant ocurridoEn, T datos) {
}
