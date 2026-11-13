# Pipeline `ci.yml`

Compila, prueba y publica `cafeorbe-contracts` en GitHub Packages, y espera el Quality Gate de Sonar. Este repositorio no se despliega: los servicios consumen el contrato clonándolo y compilándolo en su propio pipeline.

## Secretos

| Nombre | Tipo | Uso |
| --- | --- | --- |
| `SONAR_TOKEN` | secreto de organización | Quality Gate |
| `GITHUB_TOKEN` | automático | publicar el jar en GitHub Packages |

No requiere secretos de despliegue ni variables de entorno.
