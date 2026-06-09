Feature: WALLET-1719
#Descripción: Detalle de Cartera – Cartera revocada - mostrar respuesta de detalle de cartera revocada
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.
  #5. El usuario accede al detalle de una Cartera revocada al clicar sobre su id.
  #6. Se dirige al usuario a una nueva pantalla en la que se muestra el detalle de la Cartera revocada.

  #Etiquetas
  @WALLET-1719 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocada - mostrar respuesta de detalle de cartera revocada
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleccionar en el combo motivo revocacion la opcion con valor "USER_REQUEST"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo informacion general estado tiene el valor "Revocada"
    And Cerrar el navegador