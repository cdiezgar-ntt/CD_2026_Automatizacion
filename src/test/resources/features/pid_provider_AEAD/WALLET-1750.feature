Feature: WALLET-1750

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Login Portal PID Provider AEAD - mostrar respuesta al logarse mediante autentica
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    And Esperar 5 segundos
    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos

    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de búsqueda email
    And Esperar 5 segundos
    When Click en el botón buscar
    And Esperar 5 segundos

    And Click en el primer elemento de la lista con busqueda
    And Comprobar detalle cartera datos correctos "alberto.sanchez.tsol@gmail.com"
    And Cerrar el navegador

