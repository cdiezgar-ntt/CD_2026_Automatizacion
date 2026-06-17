Feature: WALLET-1756

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - búsqueda de Credenciales con error
    GivenAbrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda ""
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Cerrar el navegador

