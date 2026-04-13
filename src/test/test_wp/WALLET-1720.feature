Feature: WALLET-1720

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocada - mostrar respuesta de error en el detalle de cartera revocada
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocada"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar error en detalle cartera revocada
    And Cerrar el navegador

