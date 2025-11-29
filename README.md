# Reto 9: Microservicios con Spring Boot, Eureka y Gateway

## Descripción
Implementación de una arquitectura de microservicios distribuida utilizando el ecosistema Spring Cloud Netflix, orquestada mediante Docker Compose.

## Arquitectura
El sistema consta de tres contenedores interconectados:
1.  **Eureka Server (Puerto 8761):** Servidor de descubrimiento donde se registran los microservicios.
2.  **API Gateway (Puerto 7000):** Puerta de enlace única que enruta las peticiones a los servicios correspondientes.
3.  **Greeting Service (Puerto 8001):** Microservicio funcional que retorna un saludo y el puerto de ejecución.

## Problemas Superados y Soluciones (Bitácora Técnica)
Durante el desarrollo se presentaron desafíos de compatibilidad entre versiones recientes de Spring Boot (3.4.0) y las librerías de Spring Cloud:

* **Incompatibilidad de Versiones:** Se detectaron errores `UnsatisfiedDependencyException` y `ClassNotFoundException` al usar Spring Boot 3.4.0 con la versión actual de Cloud.
    * *Solución:* Se realizó un downgrade general a **Spring Boot 3.3.5** y **Spring Cloud 2023.0.3** en todos los servicios.
* **Falta de Librerías (JAXB/Bootstrap):** Eureka fallaba al arrancar por falta de `jaxb-runtime` (requerido en Java 17+) y `spring-cloud-starter-bootstrap`.
    * *Solución:* Se inyectaron estas dependencias manualmente en el `pom.xml`.
* **Enrutamiento del Gateway (Error 404):** El Gateway no encontraba la ruta correcta al reenviar la petición.
    * *Solución:* Se aplicó un filtro `RewritePath` en la configuración del Gateway para limpiar la URL antes de enviarla al microservicio.

## Conclusiones
La combinación de Docker con Spring Cloud permite levantar entornos complejos de forma replicable. Eureka elimina la necesidad de "hardcodear" IPs, permitiendo que los servicios se encuentren dinámicamente, mientras que el Gateway centraliza la entrada, simplificando la seguridad y el enrutamiento para el cliente final.
