Feature: WALLET-1712

  @WALLET-1712 @wallet_provider @login
  Scenario: WALLET PROVIDER - EJECUTIVO - Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Cerrar el navegador

