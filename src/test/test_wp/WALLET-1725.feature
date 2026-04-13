Feature: WALLET-1725

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras activadas - mostrar respuesta de detalle de Carteras activadas en el último mes
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle carteras activadas ultimo mes
    And Compruebo acceso a carteras activadas el ultimo mes
    And Cerrar el navegador