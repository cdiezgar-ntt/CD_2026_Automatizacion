Feature: WALLET-1735

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Histórico de revocación - reintentar revocar carteras fallidas en el detalle de histórico de revocación
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en botón historico de revocacion
    And Click en en boton accion del bloque error
    And Navega a pantalla de detalle de bloque de revocacion
    And Click en el boton reintentar revocar
    And Cerrar el navegador