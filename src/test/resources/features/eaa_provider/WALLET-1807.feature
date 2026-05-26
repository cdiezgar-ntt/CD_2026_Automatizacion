Feature: WALLET-1807

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Aceptar términos y condiciones - cancelar los términos y condiciones
    Given Abrir la web "https://pre-eaa-cd.redsara.es/control-panel/"
   # When Click en el botón acceder
   # And  Intro en certificado
    When Hacer scroll
    When Pulsar check rechazar terminos
    Then Validar que no avanza a la siguiente pantalla
 #   No existen los terminos y condiciones aun

