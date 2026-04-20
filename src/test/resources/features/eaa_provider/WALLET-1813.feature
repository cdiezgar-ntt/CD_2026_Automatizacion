Feature: WALLET-1813

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Detalle de credencial válida - mostrar respuesta de detalle de credencial válida
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click en el botón ver todas credenciales activas
    And Esperar 5 segundos
    Given Click en el primer valor de la columna ID credencial
    And Esperar 5 segundos

