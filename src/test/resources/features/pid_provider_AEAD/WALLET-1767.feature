Feature: WALLET-1767

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID revocadas - mostrar respuesta de detalle de Credenciales PID revocadas en el último mes
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle PID revocadas ultimo mes
    And Compruebo acceso a carteras revocadas el ultimo mes
    And Cerrar el navegador

