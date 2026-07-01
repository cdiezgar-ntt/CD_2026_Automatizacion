Feature: WALLET-1773

  @WALLET-1773
  Scenario: ROVIDER (AEAD) - EJECUTIVO - Revocación por archivo - mostrar respuesta de bloques y detalle del histórico de revocación sin error
    Given Abrir la web PID provider
    When Click en el botón historico revocacion
    And Click en el boton ver detalle de la credencial
    And Cerrar el navegador
