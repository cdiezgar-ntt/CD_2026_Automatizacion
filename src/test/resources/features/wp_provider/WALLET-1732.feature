Feature: WALLET-1732

  @WALLET-1732 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Histórico de revocación - mostrar respuesta de bloques y detalle del histórico de revocación sin error
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el link Historico Revocaciones
    And Esperar 5 segundos
    And Validar que el campo "wp_historicoRevocacion_titulo" de tipo "xpath" tiene el valor "Histórico revocación"
    And Validar que el campo "wp_hitoricoRevocacion_TablaEstado" de tipo "xpath" tiene el valor "Revocada"
    And Cerrar el navegador

