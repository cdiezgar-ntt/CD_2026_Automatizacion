Feature: WALLET-1720-XXXX
#Descripción: Detalle de Cartera – Cartera revocada - mostrar respuesta de error en el detalle de cartera revocada
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.
  #5. El usuario accede al detalle de una Cartera revocada al clicar sobre su id.
  #6. Se dirige al usuario a una nueva pantalla en la que se muestra un mensaje de error y no se muestra el detalle de la Cartera revocada.

  #Etiquetas
  @WALLET-1720 @wallet_provider @noejecutar
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocada - mostrar respuesta de error en el detalle de cartera revocada
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocada"
    When Click en el botón buscar - portal wallet provider
    And Click en el primer elemento de la lista - portal wallet provider
    And Comprobar error en detalle cartera revocada - portal wallet provider
    And Cerrar el navegador

