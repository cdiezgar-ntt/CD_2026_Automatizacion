Feature: WALLET-1807

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Aceptar términos y condiciones - cancelar los términos y condiciones
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Esperar 5 segundos
    When Hacer scroll
    When Pulsar check rechazar terminos


