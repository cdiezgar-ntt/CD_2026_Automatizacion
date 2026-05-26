Feature: WALLET-1751

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Leer el texto de los términos y condiciones
    And Aceptar los términos y condiciones
    And Cerrar el navegador

