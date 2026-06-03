Feature: WALLET-1896

Background:
    Given Abrir la web usuario
    And El usuario pulsa en Revocar Cartera Digital
    And El usuario introduce el mail "example1@example.com"
    And El usuario pulsa en Enviar
    Then Los digitos estan habilitados

    @portal_usuario @revocacion @otp
    Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Verificar tu identidad - el código de verificación introducido es incorrecto
      When El usuario introduce el código de verificación erróneo
      And El usuario pulsa en Continuar Revocación
      Then Se muestra error por otp erroneo