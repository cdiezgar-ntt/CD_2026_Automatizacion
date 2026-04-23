Feature: WALLET-1714

  @WALLET-1714 @wallet_provider
Scenario: WALLET PROVIDER - EJECUTIVO - Aceptar términos y condiciones - cancelar los términos y condiciones
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Leer el texto de los términos y condiciones
    And Cancelar los términos y condiciones
    And Comprobación de vuelta a la pantalla prelogin
    And Cerrar el navegador

