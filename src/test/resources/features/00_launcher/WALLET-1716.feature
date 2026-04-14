Feature: WALLET-1716

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras con filtros
    Given Abrir la web "https://pre-wp-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Intro en certificado
    And Esperar 5 segundos
    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos
    ##And Cerrar el navegador

