Feature: WALLET-1724

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras activas - mostrar respuesta de detalle de Carteras activas en el último mes
  Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
  And Esperar 5 segundos
  When Click en el botón acceder
  And  Intro en certificado
  When Click en el botón detalle carteras activas ultimo mes
    And Compruebo acceso a carteras activas el ultimo mes
    And Cerrar el navegador

