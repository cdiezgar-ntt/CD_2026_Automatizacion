Feature: WALLET-1723

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocable - mostrar respuesta de error en el detalle de cartera revocable
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocable"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar error en detalle cartera revocable
    And Cerrar el navegador