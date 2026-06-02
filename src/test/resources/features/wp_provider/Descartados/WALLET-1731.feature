Feature: WALLET-1731-XXXXX
#Descripción: Revocación por archivo - error de formato al cargar un archivo
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. El usuario pulsa en el botón “Revocación por archivo”.
  #3. La pantalla muestra un mensaje de error al cargar el archivo por formato inválido.

  #Etiquetas
  @WALLET-1731 @wallet_provider @noejecutar @wp_descartado
  Scenario: WALLET PROVIDER - EJECUTIVO - Revocación por archivo - error de formato al cargar un archivo
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar - portal wallet provider
    And Cerrar el navegador