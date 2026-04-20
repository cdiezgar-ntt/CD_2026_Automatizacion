Feature: WALLET-1816

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Detalle de credencial caducada - mostrar respuesta de error en el detalle de credencial caducada
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click en el botón ver todas credenciales revocadas
    And Esperar 5 segundos
    Given Click en el primer valor de la columna ID credencial
    And Esperar 5 segundos
    Then Muestra mensaje de error

