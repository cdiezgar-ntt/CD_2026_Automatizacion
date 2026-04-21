Feature: WALLET-1886

@portal_usuario
Scenario: PORTAL USUARIO - INICIO - Accesibilidad - mostrar respuesta al acceder a la pantalla Accesibilidad
    Given Abrir la web usuario
    Then El usuario visualiza una barra de navegación inferior con varias opciones
    And Existe la opción "Accesibilidad" en la barra de navegación
    When El usuario pulsa en accesibilidad
    Then Se carga la pagina de "Accesibilidad"