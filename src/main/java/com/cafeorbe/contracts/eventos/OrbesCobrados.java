package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/**
 * Publicado por wallet cuando descuenta al ganador el monto de la subasta que ganó (HU-20).
 *
 * @param saldo saldo del comprador después del cobro
 */
public record OrbesCobrados(
        UUID subastaId,
        UUID usuarioId,
        long monto,
        long saldo) {
}
