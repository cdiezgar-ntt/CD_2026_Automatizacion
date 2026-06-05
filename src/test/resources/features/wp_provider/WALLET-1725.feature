Feature: WALLET-1725
#Descripción: Detalle de información destacada – Carteras activadas - mostrar respuesta de detalle de Carteras activadas en el último mes
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario accede al detalle de Carteras activadas a través del botón “Ver todas”.
  #4. Se dirige al usuario a una nueva pantalla en la que se mostrarán todas las Carteras activadas y, además, se podrá filtrar para acotar la búsqueda y revocar las Carteras que seleccione el usuario.

  #Etiquetas
  @WALLET-1725 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de información destacada – Carteras activadas - mostrar respuesta de detalle de Carteras activadas en el último mes
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón ver todas carteras activadas ultimo mes
    And Esperar 5 segundos
    And Validar que el campo "wp_carterasActivadas_titulo" de tipo "xpath" tiene el valor "Carteras activadas"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_titulo" de tipo "xpath" tiene el valor "Detalle cartera"
    And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "xpath" tiene el valor "Cartera operativa"
    And Cerrar el navegador