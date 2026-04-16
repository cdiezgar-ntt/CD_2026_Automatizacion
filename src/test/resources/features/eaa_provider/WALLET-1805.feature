Feature: WALLET-1805

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Login Portal EAA Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder

