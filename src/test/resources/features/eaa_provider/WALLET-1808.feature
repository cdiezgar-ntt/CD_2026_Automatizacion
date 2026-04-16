Feature: WALLET-1808

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de credenciales sin filtros
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos


