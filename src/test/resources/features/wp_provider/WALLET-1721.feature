Feature: WALLET-1721-XXXX

  @WALLET-1721 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocable - mostrar respuesta de detalle de cartera revocable
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocable"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle cartera revocada
    And Cerrar el navegador