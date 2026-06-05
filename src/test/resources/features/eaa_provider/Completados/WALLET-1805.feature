Feature: WALLET-1805

@portal_eaa @login @WALLET-1805
Scenario: EAA PROVIDER - CONSULTIVO - Login Portal EAA Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web EAA provider
    Then Validar que se accede al panel de control de EAA
    When El usuario pulsa en buscar
    Then Se muestra un listado de credenciales


