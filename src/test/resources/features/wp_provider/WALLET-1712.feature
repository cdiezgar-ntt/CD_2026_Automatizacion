Feature: WALLET-1712
#Descripción: Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
  #Pasos:
  #1. El usuario accede al Portal de Administración de Wallet Provider de Cartera Digital mediante una url válida.
  #2. El usuario accede a la pantalla de Prelogin.
  #3. El usuario inicia sesión mediante su certificado electrónico a través de autentica con un rol ejecutivo.
  #4. El usuario accede a la pantalla de inicio.

  #Etiquetas
  @WALLET-1712 @wallet_provider @login
  Scenario: WALLET PROVIDER - EJECUTIVO - Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
    Given Abrir la web wallet provider
    When Click en el botón acceder
    And Cerrar el navegador

