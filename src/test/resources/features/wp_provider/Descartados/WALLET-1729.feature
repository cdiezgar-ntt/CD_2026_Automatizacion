Feature: WALLET-1729-XXXX
#Descripción: Revocación por archivo - mostrar respuesta tras revocación de carteras seleccionadas al cargar un archivo
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. El usuario pulsa en el botón “Revocación por archivo”.
  #3. La pantalla muestra una modal para elegir el archivo que contenta las direcciones de correo electrónico asociadas a las Carteras que se quieran revocar.
  #4. Una vez se ha cargado el archivo el usuario pulsa el botón “Consultar y revocar”.
  #5. Se dirige al usuario a una nueva pantalla en la que se muestran todas las Carteras incluidas en el archivo.
  #6. El usuario selecciona las Carteras que desee revocar y pulsa en el botón “Revocar seleccionadas”.
  #7. El usuario introduce el motivo de revocación y pulsa en el botón “Sí, revocar”.
  #8. La pantalla muestra un mensaje de confirmación del proceso de revocación y el usuario puede volver al inicio o ir a la pantalla de detalle de la revocación.

  #Etiquetas
  @WALLET-1729 @wallet_provider @noejecutar @wp_descartado
  Scenario: WALLET PROVIDER - EJECUTIVO - Revocación por archivo - mostrar respuesta tras revocación de carteras seleccionadas al cargar un archivo
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar - portal wallet provider
    And Cerrar el navegador