Feature: WALLET-1750

  @Test
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Login Portal PID Provider AEAD - mostrar respuesta al logarse mediante autentica
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Cerrar el navegador

