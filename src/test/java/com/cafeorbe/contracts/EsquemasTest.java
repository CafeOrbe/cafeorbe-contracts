package com.cafeorbe.contracts;

import com.cafeorbe.contracts.dto.PujaSolicitud;
import com.cafeorbe.contracts.dto.SaldoDto;
import com.cafeorbe.contracts.eventos.OrbesCobrados;
import com.cafeorbe.contracts.eventos.PujaAceptada;
import com.cafeorbe.contracts.eventos.PujaRechazada;
import com.cafeorbe.contracts.eventos.SubastaIniciada;
import com.cafeorbe.contracts.eventos.TiempoExtendido;
import com.cafeorbe.contracts.eventos.TransmisionDetenida;
import com.cafeorbe.contracts.eventos.TransmisionIniciada;
import com.cafeorbe.contracts.eventos.UsuarioRegistrado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/** Los contratos son datos puros: estas pruebas fijan los campos que los servicios se intercambian. */
class EsquemasTest {

    private static final UUID SUBASTA = UUID.randomUUID();
    private static final UUID USUARIO = UUID.randomUUID();
    private static final Instant AHORA = Instant.parse("2026-10-08T12:00:00Z");

    @Test
    @DisplayName("EventoEnvelope envuelve los datos con su id, tipo, versión e instante")
    void sobre() {
        UUID eventId = UUID.randomUUID();
        var datos = new TransmisionIniciada(SUBASTA, "subasta-" + SUBASTA);

        var sobre = new EventoEnvelope<>(eventId, Eventos.TRANSMISION_INICIADA, 1, AHORA, datos);

        assertThat(sobre.eventId()).isEqualTo(eventId);
        assertThat(sobre.tipo()).isEqualTo("transmision.iniciada");
        assertThat(sobre.version()).isEqualTo(1);
        assertThat(sobre.ocurridoEn()).isEqualTo(AHORA);
        assertThat(sobre.datos().sala()).isEqualTo("subasta-" + SUBASTA);
    }

    @Test
    @DisplayName("Eventos de pujas: aceptada, rechazada y tiempo extendido")
    void eventosDePujas() {
        var aceptada = new PujaAceptada(SUBASTA, UUID.randomUUID(), USUARIO, "Ana", 300, 2, 350, AHORA);
        var rechazada = new PujaRechazada(SUBASTA, USUARIO, 100, "MONTO_BAJO", "Muy baja");
        var extendido = new TiempoExtendido(SUBASTA, 30, AHORA, 1, 3);

        assertThat(aceptada.monto()).isEqualTo(300);
        assertThat(aceptada.siguienteMinimo()).isEqualTo(350);
        assertThat(rechazada.motivo()).isEqualTo("MONTO_BAJO");
        assertThat(rechazada.montoIntentado()).isEqualTo(100);
        assertThat(extendido.segundosExtendidos()).isEqualTo(30);
        assertThat(extendido.maximoExtensiones()).isEqualTo(3);
    }

    @Test
    @DisplayName("Eventos de subasta, usuario, cobro y transmisión")
    void otrosEventos() {
        var iniciada = new SubastaIniciada(SUBASTA, "Lote", 100, 10, 5, AHORA, AHORA.plusSeconds(300));
        var registrado = new UsuarioRegistrado(USUARIO, "Ana", "COMPRADOR");
        var cobrados = new OrbesCobrados(SUBASTA, USUARIO, 300, 700);
        var detenida = new TransmisionDetenida(SUBASTA);

        assertThat(iniciada.horaFin()).isEqualTo(AHORA.plusSeconds(300));
        assertThat(iniciada.precioBase()).isEqualTo(100);
        assertThat(registrado.rol()).isEqualTo(Rol.COMPRADOR.name());
        assertThat(cobrados.saldo()).isEqualTo(700);
        assertThat(detenida.subastaId()).isEqualTo(SUBASTA);
    }

    @Test
    @DisplayName("DTOs de puja y saldo")
    void dtos() {
        assertThat(new PujaSolicitud(250).monto()).isEqualTo(250);
        assertThat(new SaldoDto(USUARIO, 900)).isEqualTo(new SaldoDto(USUARIO, 900));
        assertThat(new SaldoDto(USUARIO, 900).saldo()).isEqualTo(900);
    }
}
