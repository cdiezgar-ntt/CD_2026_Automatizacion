Feature: WALLET-1719

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocada - mostrar respuesta de detalle de cartera revocada
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocada"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle cartera revocada
    And Cerrar el navegador