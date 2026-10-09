package com.cafeorbe.contracts.eventos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrbesAbonadosTest {

    @Test
    @DisplayName("OrbesAbonados lleva la subasta, el Subastador abonado, el monto y su saldo final")
    void campos() {
        UUID subasta = UUID.randomUUID();
        UUID subastador = UUID.randomUUID();

        var evento = new OrbesAbonados(subasta, subastador, 300, 1300);

        assertThat(evento.subastaId()).isEqualTo(subasta);
        assertThat(evento.usuarioId()).isEqualTo(subastador);
        assertThat(evento.monto()).isEqualTo(300);
        assertThat(evento.saldo()).isEqualTo(1300);
    }
}
