Feature: WALLET-1815

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Detalle de credencial caducada - mostrar respuesta de detalle de credencial caducada
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click en el botón ver todas credenciales revocadas
    And Esperar 5 segundos
    Given Click en el primer valor de la columna ID credencial
    And Esperar 5 segundos


