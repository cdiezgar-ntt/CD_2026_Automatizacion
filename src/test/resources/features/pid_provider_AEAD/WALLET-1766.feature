Feature: WALLET-1766

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID emitidas - mostrar respuesta de detalle de Credenciales PID emitidas en el último mes
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle PID activas ultimo mes
    And Compruebo acceso a PID activas el ultimo mes
    And Cerrar el navegador


