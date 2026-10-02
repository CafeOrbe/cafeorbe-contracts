package com.cafeorbe.contracts.eventos;

import java.time.Instant;
import java.util.UUID;

/**
 * Publicado por auction cuando la subasta cierra al terminar su tiempo (HU-19).
 * Con pujas queda {@code FINALIZADA} y trae al ganador; sin pujas queda {@code DESIERTA} y el ganador es nulo.
 *
 * @param estado        {@code FINALIZADA} o {@code DESIERTA}
 * @param ganadorId     comprador de la última puja válida, o {@code null} si quedó desierta
 * @param ganadorNombre nombre del ganador, o {@code null} si quedó desierta
 * @param montoFinal    monto de la puja ganadora, o {@code null} si quedó desierta
 */
public record SubastaCerrada(
        UUID subastaId,
        String nombre,
        String estado,
        UUID ganadorId,
        String ganadorNombre,
        Long montoFinal,
        int cantidadPujas,
        Instant cerradaEn) {
}
