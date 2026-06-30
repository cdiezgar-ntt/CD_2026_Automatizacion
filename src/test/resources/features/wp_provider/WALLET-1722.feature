Feature: WALLET-1722-XXXX
#Descripción: Detalle de Cartera – Cartera revocable - revocar cartera a través del detalle de cartera revocable
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.
  #5. El usuario accede al detalle de una Cartera que no se encuentra revocada al clicar sobre su id.
  #6. Se dirige al usuario a una nueva pantalla en la que se muestra el detalle de la Cartera que no se encuentra revocada.
  #7. El usuario pulsa en el botón “Revocar Cartera”.
  #8. La pantalla muestra una modal en la que el usuario indicará el motivo de revocación de la Cartera.
  #9. El usuario pulsa en “Sí, revocar”.

  #Etiquetas
  @WALLET-1722 @wallet_provider @noejecutar
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocable - revocar cartera a través del detalle de cartera revocable
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleccionar en el combo con estado la opcion con valor "VALID"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    #And Validar que el campo "wp_detalleCartera_InformacionGeneral_estado" de tipo "tag" tiene el valor "Cartera operativa"
    And Click en el botón revocar cartera
    #And Seleccionar en el combo con xpath "wp_detalleCartera_RevocacionComboMotivoRevocacion" la opcion con valor "MOBILE_PHONE_LOSS"
    When El usuario despliega los motivos de revocacion
    And El usuario elige el motivo "Cambio de datos de identidad"
    And Click en el botón confirmar revocación
    And Acepta la alerta de autofirma
    And Esperar 5 segundos
    And Selecciona su certificado en autofirma
    And Cerrar el navegador
