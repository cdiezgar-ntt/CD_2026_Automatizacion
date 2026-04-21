Feature: WALLET-1890

@portal_usuario
Scenario: PORTAL USUARIO - INICIO - Política de cookies - mostrar respuesta al acceder a la pantalla Política de cookies
      Given Abrir la web usuario
      Then El usuario visualiza una barra de navegación inferior con varias opciones
      And Existe la opción "Política de cookies" en la barra de navegación
      When El usuario pulsa en política de cookies
      Then Se carga la pagina de "Política de cookies"

