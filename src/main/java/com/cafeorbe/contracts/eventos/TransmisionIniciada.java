package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/** Publicado por streaming cuando el Subastador empieza a transmitir. */
public record TransmisionIniciada(UUID subastaId, String sala) {
}
