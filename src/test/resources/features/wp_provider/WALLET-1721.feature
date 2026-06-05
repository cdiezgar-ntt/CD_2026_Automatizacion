Feature: WALLET-1721-XXXX
#Descripción: Detalle de Cartera – Cartera revocable - mostrar respuesta de detalle de cartera revocable
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.
  #5. El usuario accede al detalle de una Cartera que no se encuentra revocada al clicar sobre su id.
  #6. Se dirige al usuario a una nueva pantalla en la que se muestra el detalle de la Cartera que no se encuentra revocada.

  #Etiquetas
  @WALLET-1721 @wallet_provider @noejecutar
  Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocable - mostrar respuesta de detalle de cartera revocable
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleccionar en el combo con id "wp_pantallaInicio_ComboEstado" la opcion con valor "VALID"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "tag" tiene el valor "Cartera operativa"
    And Cerrar el navegador