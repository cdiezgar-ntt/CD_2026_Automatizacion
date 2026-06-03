Feature: WALLET-1894

@portal_usuario @revocacion @validaciones
Scenario Outline: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Verificar tu identidad - el email introducido no tiene el formato correcto - <email_invalido>
      Given Abrir la web usuario
      Then El usuario visualiza 3 tipos de revocación
      When El usuario pulsa en Revocar Cartera Digital
      Then El usuario accede a la pantalla "Revocación total de Cartera Digital"
      When El usuario introduce el email invalido "<email_invalido>"
      And El usuario pulsa en Enviar
      Then El portal devuelve un mensaje de error
      And Los digitos estan deshabilitados
      And El botón continuar revocación está deshabilitado

      Examples:
        | email_invalido       |
        | usuario.dominio.com  |
        | usuario@@dominio.com |
        | @dominio.com         |
        | usuario@             |
        | usuario@dominio      |
        | usuario@dominio..com |
        | usuario@-dominio.com |
        | usuario@dominio-.com |
        | usuario@dom inio.com |
