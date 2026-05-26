Feature: WALLET-1762

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de información destacada – Credenciales PID activas - mostrar respuesta de detalle de Credenciales PID activas en el último mes
    Given Abrir la web PID provider
    When Click en el botón acceder
    When Click en el botón detalle pid activas ultimo mes
    And Compruebo acceso a carteras activas el ultimo mes
    And Cerrar el navegador
