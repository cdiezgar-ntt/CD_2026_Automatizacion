Feature: WALLET-1819

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Detalle de información destacada – Credenciales emitidas - mostrar respuesta de detalle de Credenciales emitidas en el último mes
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Click boton ultimo mes
    When Click en el botón buscar
    And Esperar 5 segundos