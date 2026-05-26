Feature: WALLET-1806

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Hacer scroll
    When Pulsar check aceptar terminos
    When Click en el boton continuar
    Then Validar que avanza a la siguiente pantalla
 #   No existen los terminos y condiciones aun