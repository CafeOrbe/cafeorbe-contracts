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
 * @param subastadorId  dueño de la subasta; wallet le abona lo cobrado al ganador (HU-24)
 */
public record SubastaCerrada(
        UUID subastaId,
        String nombre,
        String estado,
        UUID ganadorId,
        String ganadorNombre,
        Long montoFinal,
        int cantidadPujas,
        Instant cerradaEn,
        UUID subastadorId) {

    /** Para eventos sin subastador conocido (el abono HU-24 se omite). */
    public SubastaCerrada(UUID subastaId, String nombre, String estado, UUID ganadorId, String ganadorNombre,
                          Long montoFinal, int cantidadPujas, Instant cerradaEn) {
        this(subastaId, nombre, estado, ganadorId, ganadorNombre, montoFinal, cantidadPujas, cerradaEn, null);
    }
}
