package com.cafeorbe.contracts.eventos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class SubastaCerradaTest {

    private static final UUID SUBASTA = UUID.randomUUID();
    private static final UUID GANADOR = UUID.randomUUID();
    private static final UUID SUBASTADOR = UUID.randomUUID();
    private static final Instant CERRADA_EN = Instant.parse("2026-10-08T12:00:00Z");

    @Test
    @DisplayName("Con subastador: wallet sabe a quién abonar lo cobrado (HU-24)")
    void conSubastador() {
        var evento = new SubastaCerrada(SUBASTA, "Lote", "FINALIZADA", GANADOR, "Ana", 300L, 5, CERRADA_EN, SUBASTADOR);

        assertThat(evento.subastadorId()).isEqualTo(SUBASTADOR);
        assertThat(evento.ganadorId()).isEqualTo(GANADOR);
        assertThat(evento.montoFinal()).isEqualTo(300L);
    }

    @Test
    @DisplayName("Sin subastador (eventos anteriores a HU-24): el campo queda nulo y el resto se conserva")
    void sinSubastador() {
        var evento = new SubastaCerrada(SUBASTA, "Lote", "DESIERTA", null, null, null, 0, CERRADA_EN);

        assertThat(evento.subastadorId()).isNull();
        assertThat(evento.estado()).isEqualTo("DESIERTA");
        assertThat(evento.cerradaEn()).isEqualTo(CERRADA_EN);
        assertThat(evento).isEqualTo(
                new SubastaCerrada(SUBASTA, "Lote", "DESIERTA", null, null, null, 0, CERRADA_EN, null));
    }
}
