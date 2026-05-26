Feature: WALLET-1893

@Test
Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Verificar tu identidad - mostrar respuesta al completar todos los campos del paso 1
      Given Abrir la web usuario
      Then El usuario visualiza 3 tipos de revocación
      When El usuario pulsa en Revocar Cartera Digital
      Then El usuario accede a la pantalla "Revocación Cartera Digital"
      And El botón continuar revocación está deshabilitado
      And Los digitos estan deshabilitados
      When El usuario introduce el mail de una cartera válida
      And El usuario pulsa en Enviar
      # En PRE hay mock y no se comprueba la recepción del mail
      Then El usuario recibe un código de verificación
      And Los digitos estan habilitados
      When El usuario introduce el código de verificación recibido
      Then Se desbloquea el botón continuar revocación