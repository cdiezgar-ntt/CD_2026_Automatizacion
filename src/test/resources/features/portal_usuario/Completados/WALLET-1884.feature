Feature: WALLET-1884

@portal_usuario @home
Scenario: PORTAL USUARIO - INICIO - Landing portal usuario - mostrar pantalla de inicio con 3 opciones de acceso
      Given Abrir la web usuario
      Then El usuario visualiza 3 tipos de revocación
      And El usuario visualiza la opción de revocación "Revocación totasl de Cartera Digital"
      And El usuario visualiza la opción de revocación "Revocación de tu credencial de Identidad Digital online"
      And El usuario visualiza la opción de revocación "Revocación presencial"