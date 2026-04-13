Feature: WALLET-1726

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras revocadas - mostrar respuesta de detalle de Carteras revocadas en el último mes
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle carteras revocadas ultimo mes
    And Compruebo acceso a carteras revocadas el ultimo mes
    And Cerrar el navegador
