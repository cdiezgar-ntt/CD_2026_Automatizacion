Feature: WALLET-1805

  @test
Scenario: EAA PROVIDER - CONSULTIVO - Login Portal EAA Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web "https://pre-pid-cd.redsara.es/auth/login"
    When Click en el botón acceder
    Then Validar que se accede al panel de control
  #  Al indicar el certificado la url a la que direcciona es http y no https por lo que el flujo no es correcto

