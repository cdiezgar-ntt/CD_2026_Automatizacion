Feature: WALLET-1716

  @WALLET-1716 @wallet_provider @inicio
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras con filtros
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de busqueda email
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_InformacionContacto_email" de tipo "xpath" tiene el valor "alberto.sanchez.tsol@gmail.com"
    And Cerrar el navegador