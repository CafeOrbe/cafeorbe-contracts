package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/** Publicado por streaming cuando el Subastador detiene la transmisión. */
public record TransmisionDetenida(UUID subastaId) {
}
