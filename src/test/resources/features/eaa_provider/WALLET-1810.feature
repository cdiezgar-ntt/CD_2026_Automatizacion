Feature: WALLET-1810

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Pantalla inicio - búsqueda de credenciales sin resultados
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Rellenar el texto "testprueba123@gmail.com" en el campo de búsqueda email
    When Click en el botón buscar
    And Esperar 5 segundos
    Then Validar que la busqueda no devuelve resultados
