package com.cafeorbe.contracts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class EventosTest {

    @Test
    @DisplayName("Cada tipo de evento es único: se usa como routing key del exchange")
    void tiposUnicos() {
        var tipos = Arrays.stream(Eventos.class.getFields())
                .filter(campo -> Modifier.isStatic(campo.getModifiers()) && campo.getType() == String.class)
                .map(campo -> {
                    try {
                        return (String) campo.get(null);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                })
                .toList();

        assertThat(tipos).doesNotHaveDuplicates().contains(Eventos.SUBASTA_CERRADA, Eventos.ORBES_ABONADOS);
        assertThat(Eventos.ORBES_ABONADOS).isEqualTo("orbes.abonados");
    }

    @Test
    @DisplayName("Eventos y Cabeceras son solo constantes: no se pueden instanciar desde fuera")
    void sinInstancias() throws ReflectiveOperationException {
        for (Class<?> clase : new Class<?>[] {Eventos.class, Cabeceras.class}) {
            Constructor<?> constructor = clase.getDeclaredConstructor();
            assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
            constructor.setAccessible(true);
            assertThat(constructor.newInstance()).isNotNull();
        }
    }

    @Test
    @DisplayName("Las cabeceras de usuario conservan los nombres que el gateway y los servicios esperan")
    void cabeceras() {
        assertThat(Cabeceras.USUARIO_ID).isEqualTo("X-User-Id");
        assertThat(Cabeceras.USUARIO_NOMBRE).isEqualTo("X-User-Name");
        assertThat(Cabeceras.USUARIO_ROL).isEqualTo("X-User-Role");
        assertThat(Rol.valueOf("SUBASTADOR")).isEqualTo(Rol.values()[0]);
    }
}
