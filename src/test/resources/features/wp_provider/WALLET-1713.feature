Feature: WALLET-1713
#Descripción: Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario accede a la pantalla de términos y condiciones del Wallet Provider.
  #2. El usuario lee los términos y condiciones del portal.
  #3. El usuario acepta los términos y condiciones y pulsa en el botón “Confirmar”.
  #4. Se dirige al usuario a la pantalla de inicio del Portal de Administración.

  #Etiquetas
  @WALLET-1713 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Leer el texto de los términos y condiciones
    And Aceptar los términos y condiciones
    And Cerrar el navegador