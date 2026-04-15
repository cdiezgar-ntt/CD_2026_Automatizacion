Feature: WALLET-1888

  @TC_01
Scenario: PORTAL USUARIO - INICIO - Aviso Legal - mostrar respuesta al acceder a la pantalla Aviso Legal
    Given Abrir la web "https://pre-citizen-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Acceder a la pantalla Aviso Legal por el pie de pagina
    Then Visualizar el contenido del aviso legal
