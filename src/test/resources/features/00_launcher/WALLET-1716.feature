Feature: WALLET-1716

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras con filtros
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    #And Esperar 5 segundos
    When Click en el botón acceder
    #And  Intro en certificado
    #When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    #And Comprobar detalle cartera datos correctos "alberto.sanchez.tsol@gmail.com"
    And Cerrar el navegador

