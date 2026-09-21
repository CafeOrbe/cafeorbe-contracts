package com.cafeorbe.contracts.eventos;

import java.util.UUID;

/** Publicado por identity la primera vez que una persona ingresa con un nombre y rol. */
public record UsuarioRegistrado(UUID usuarioId, String nombre, String rol) {
}
