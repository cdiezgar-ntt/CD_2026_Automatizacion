Feature: WALLET-1712

  @TC_01
  Scenario: WALLET PROVIDER - EJECUTIVO - Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Cerrar el navegador

