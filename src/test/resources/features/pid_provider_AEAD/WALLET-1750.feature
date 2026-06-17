Feature: WALLET-1750
#Descripción: Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
  #Pasos:
  #1. El usuario accede al Portal de Administración de Pid Provider de Cartera Digital mediante una url válida.
  #2. El usuario accede a la pantalla de Prelogin.
  #3. El usuario inicia sesión mediante su certificado electrónico a través de autentica con un rol ejecutivo.
  #4. El usuario accede a la pantalla de inicio.

  #Etiquetas
@WALLET-1750
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Login Portal PID Provider AEAD - mostrar respuesta al logarse mediante autentica
    Given Abrir la web PID provider
    Then Se abre el portal PID Provider
    And Cerrar el navegador

