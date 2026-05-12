Feature: WALLET-1730-XXXX

  @WALLET-1730 @wallet_provider
Scenario: WALLET PROVIDER - EJECUTIVO - Revocación por archivo - mostrar respuesta de error tras revocación de carteras seleccionadas al cargar un archivo
  Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
  And Esperar 5 segundos
  When Click en el botón acceder
  And  Intro en certificado
  When Click en el botón buscar
  And Click en el primer elemento de la lista
    And Cerrar el navegador

