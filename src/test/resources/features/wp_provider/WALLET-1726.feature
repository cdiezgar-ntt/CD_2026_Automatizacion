Feature: WALLET-1726

  @WALLET-1726 @wallet_provider
  Scenario: Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras revocadas - mostrar respuesta de detalle de Carteras revocadas en el último mes
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón ver todas carteras revocadas ultimo mes
    And Esperar 5 segundos
    And Validar que el campo "wp_carterasActivas_titulo" de tipo "xpath" tiene el valor "Carteras revocadas"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_titulo" de tipo "xpath" tiene el valor "Detalle cartera"
    And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "xpath" tiene el valor "Revocada"
    And Cerrar el navegador