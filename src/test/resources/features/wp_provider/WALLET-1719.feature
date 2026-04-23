Feature: WALLET-1719

  @WALLET-1719 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocada - mostrar respuesta de detalle de cartera revocada
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleccionar en el combo con id "wp_pantallaInicio_ComboMotivoRevocacion" la opcion con valor "USER_REQUEST"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "xpath" tiene el valor "Revocada"
    And Cerrar el navegador