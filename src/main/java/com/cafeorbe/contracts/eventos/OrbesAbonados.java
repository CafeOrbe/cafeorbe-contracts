package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/**
 * Publicado por wallet cuando abona al Subastador lo cobrado al ganador de su subasta (HU-24).
 *
 * @param usuarioId Subastador que recibe el abono
 * @param saldo     saldo del Subastador después del abono
 */
public record OrbesAbonados(
        UUID subastaId,
        UUID usuarioId,
        long monto,
        long saldo) {
}
