# cafeorbe-contracts

Esquemas de eventos y DTOs versionados que comparten los servicios de CaféOrbe.
**Sin lógica de negocio**: solo records, constantes y el sobre común `EventoEnvelope`.

## Uso

```bash
mvn install          # publica el jar en el repositorio Maven local (~/.m2)
```

Los servicios dependen de `com.cafeorbe:cafeorbe-contracts:0.1.0-SNAPSHOT`. Hay que ejecutar
`mvn install` aquí **antes** de compilar cualquier servicio.

## Eventos (exchange topic `cafeorbe.eventos`)

| Routing key | Record | Publica | Consume |
|---|---|---|---|
| `usuario.registrado` | `UsuarioRegistrado` | identity | wallet |
| `subasta.iniciada` | `SubastaIniciada` | auction | realtime |
| `puja.aceptada` | `PujaAceptada` | auction | realtime |
| `puja.rechazada` | `PujaRechazada` | auction | realtime (solo a quien pujó) |
| `transmision.iniciada` | `TransmisionIniciada` | streaming | realtime |
| `transmision.detenida` | `TransmisionDetenida` | streaming | realtime |

Cada mensaje viaja dentro de `EventoEnvelope<T>` (`eventId`, `tipo`, `version`, `ocurridoEn`, `datos`).
Cambios incompatibles en `datos` implican subir `version`.
