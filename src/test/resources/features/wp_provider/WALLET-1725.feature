Feature: WALLET-1725

  @WALLET-1725 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras activadas - mostrar respuesta de detalle de Carteras activadas en el último mes
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón ver todas carteras activadas ultimo mes
    And Esperar 5 segundos
    And Validar que el campo "wp_carterasActivas_titulo" de tipo "xpath" tiene el valor "Carteras activadas"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_titulo" de tipo "xpath" tiene el valor "Detalle cartera"
    And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "xpath" tiene el valor "Cartera operativa"
    And Cerrar el navegador