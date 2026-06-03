Feature: WALLET-1895

@portal_usuario @revocacion @validaciones
Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Verificar tu identidad - no hay ninguna Cartera Digital asociada al email introducido
    Given Abrir la web usuario
    When El usuario pulsa en Revocar Cartera Digital
    And El usuario introduce el mail "pruebas_pruebitas@mail_fake.com"
    And El usuario pulsa en Enviar
    Then Se muestra error porque no existe cartera