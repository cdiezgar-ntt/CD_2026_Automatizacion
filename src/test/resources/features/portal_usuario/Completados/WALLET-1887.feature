Feature: WALLET-1887

@portal_usuario
Scenario: PORTAL USUARIO - INICIO - Mapa Web - mostrar respuesta al acceder a la pantalla Mapa Web
      Given Abrir la web usuario
      Then El usuario visualiza una barra de navegación inferior con varias opciones
      And Existe la opción "Mapa Web" en la barra de navegación
      When El usuario pulsa en mapa web
      Then Se carga la pagina de "Mapa Web"
    #And El usuario visualiza los requisitos de accesibilidad del Portal de Usuario -- PTE HASTA QUE SE DEFINAN REQUISITOS