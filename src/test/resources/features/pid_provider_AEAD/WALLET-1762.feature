Feature: WALLET-1762

  @WALLET-1762
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID activas - mostrar respuesta de detalle de Credenciales PID activas en el último mes
    Given Abrir la web PID provider
    When Click en el botón ver todas pid activas ultimo mes
    And Click en el primer elemento de la lista de credenciales
    And Validar que el campo informacion general estado credencial tiene el valor "Válida"
    And Cerrar el navegador
