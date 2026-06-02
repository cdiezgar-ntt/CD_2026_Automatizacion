Feature: WALLET-1714
#Descripción: Aceptar términos y condiciones - cancelar los términos y condiciones
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario accede a la pantalla de términos y condiciones del Wallet Provider.
  #2. El usuario lee los términos y condiciones del portal.
  #3. El usuario cancela los términos y condiciones y pulsa en el botón “Cancelar”.
  #4. Se dirige al usuario a la pantalla de prelogin del Portal de Administración.

  #Etiquetas
  @WALLET-1714 @wallet_provider @wp_descartado
Scenario: WALLET PROVIDER - EJECUTIVO - Aceptar términos y condiciones - cancelar los términos y condiciones
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Leer el texto de los términos y condiciones
    And Cancelar los términos y condiciones
    And Comprobación de vuelta a la pantalla prelogin
    And Cerrar el navegador

