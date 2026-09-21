package com.cafeorbe.contracts.dto;

import java.util.UUID;

/** Respuesta de wallet con el saldo de Orbes de un usuario. */
public record SaldoDto(UUID usuarioId, long saldo) {
}
