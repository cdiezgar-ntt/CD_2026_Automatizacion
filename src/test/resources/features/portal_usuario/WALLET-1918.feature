Feature: WALLET-1918

  @TC_01
Scenario: PORTAL USUARIO - REVOCACIÓN PRESENCIAL - Traducción flujo Revocación Presencial - traducción del flujo Revocación presencial a todos los idiomas disponibles
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Esperar 5 segundos
    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos

    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos

    And Click en el primer elemento de la lista con busqueda
    And Comprobar detalle cartera datos correctos "alberto.sanchez.tsol@gmail.com"
    And Cerrar el navegador

