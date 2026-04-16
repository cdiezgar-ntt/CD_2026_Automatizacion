Feature: WALLET-1811

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Pantalla inicio - búsqueda de credenciales con error
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos
    Then Muestra mensaje de error
