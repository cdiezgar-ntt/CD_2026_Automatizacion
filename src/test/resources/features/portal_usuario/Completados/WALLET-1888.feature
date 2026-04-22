Feature: WALLET-1888

@portal_usuario @navegacion
Scenario: PORTAL USUARIO - INICIO - Aviso Legal - mostrar respuesta al acceder a la pantalla Aviso Legal
    Given Abrir la web usuario
    Then El usuario visualiza una barra de navegación inferior con varias opciones
    And Existe la opción "Aviso Legal" en la barra de navegación
    When El usuario pulsa en aviso legal
    Then Se carga la pagina de "Aviso Legal"