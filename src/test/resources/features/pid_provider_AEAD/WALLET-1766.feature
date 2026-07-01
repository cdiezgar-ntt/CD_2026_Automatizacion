Feature: WALLET-1766

  @WALLET-1766
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID emitidas - mostrar respuesta de detalle de Credenciales PID emitidas en el último mes
    Given Abrir la web PID provider
    When Click en el botón detalle PID emitidas ultimo mes
    And Click en el primer elemento de la lista de credenciales
    And Validar que el campo informacion general estado credencial tiene un valor valido
    And Cerrar el navegador


