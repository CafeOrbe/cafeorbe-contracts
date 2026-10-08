package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/**
 * Publicado por wallet cuando abona al Subastador los Orbes de la subasta que vendió (HU-24).
 * Ocurre en la misma operación que el cobro al ganador: si no se pudo cobrar, no hay abono.
 *
 * @param usuarioId el Subastador que recibe los Orbes
 * @param saldo     saldo del Subastador después del abono
 */
public record OrbesAbonados(
        UUID subastaId,
        UUID usuarioId,
        long monto,
        long saldo) {
}
