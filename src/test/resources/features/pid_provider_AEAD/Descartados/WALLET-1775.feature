Feature: WALLET-1775

  @TC_01
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocación por archivo - mostrar respuesta de bloques y detalle del histórico de revocación en proceso
    Given Abrir la web PID provider
    When Click en el botón historico revocacion

    And Click en el boton ver detalle de la credencial
    And Cerrar el navegador

