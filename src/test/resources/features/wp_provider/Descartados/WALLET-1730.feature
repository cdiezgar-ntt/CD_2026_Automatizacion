Feature: WALLET-1730-XXXX
#Descripción: Revocación por archivo - mostrar respuesta de error tras revocación de carteras seleccionadas al cargar un archivo
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. El usuario pulsa en el botón “Revocación por archivo”.
  #3. La pantalla muestra una modal para elegir el archivo que contenta las direcciones de correo electrónico asociadas a las Carteras que se quieran revocar.
  #4. Una vez se ha cargado el archivo el usuario pulsa el botón “Consultar y revocar”.
  #5. Se muestra en la modal un mensaje de error al intentar realizar la revocación por archivo.

  #Etiquetas
  @WALLET-1730 @wallet_provider @noejecutar @wp_descartado
Scenario: WALLET PROVIDER - EJECUTIVO - Revocación por archivo - mostrar respuesta de error tras revocación de carteras seleccionadas al cargar un archivo
  Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
  And Esperar 5 segundos
  When Click en el botón acceder
  And  Intro en certificado
  When Click en el botón buscar - portal wallet provider
  And Click en el primer elemento de la lista - portal wallet provider
    And Cerrar el navegador

