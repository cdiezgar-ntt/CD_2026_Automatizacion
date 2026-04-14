Feature: WALLET-1718

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras con error
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda ""
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Cerrar el navegador

