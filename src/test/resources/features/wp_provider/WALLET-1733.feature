Feature: WALLET-1733-XXXX

  @WALLET-1733 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Histórico de revocación - mostrar respuesta de bloques y detalle del histórico de revocación con error
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en botón historico de revocacion
    And Click en en boton accion del bloque error
    And Navega a pantalla de detalle de bloque de revocacion
    And Cerrar el navegador