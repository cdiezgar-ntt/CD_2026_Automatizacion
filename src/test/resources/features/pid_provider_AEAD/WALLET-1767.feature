Feature: WALLET-1767

  @WALLET-1767
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID revocadas - mostrar respuesta de detalle de Credenciales PID revocadas en el último mes
    Given Abrir la web PID provider
    When Click en el botón ver todas pid revocadas ultimo mes
    And Click en el primer elemento de la lista de credenciales
    And Validar que el campo informacion general estado credencial tiene el valor "Revocada"
    And Cerrar el navegador
