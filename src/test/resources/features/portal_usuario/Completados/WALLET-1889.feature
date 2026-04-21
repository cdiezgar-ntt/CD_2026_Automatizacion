Feature: WALLET-1889

@portal_usuario
Scenario: PORTAL USUARIO - INICIO - Política de Privacidad - mostrar respuesta al acceder a la pantalla Política de Privacidad
  Given Abrir la web usuario
  Then El usuario visualiza una barra de navegación inferior con varias opciones
  And Existe la opción "Política de Privacidad" en la barra de navegación
  When El usuario pulsa en politica de privacidad
  Then Se carga la pagina de "Política de Privacidad"