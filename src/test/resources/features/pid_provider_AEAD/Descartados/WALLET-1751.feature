Feature: WALLET-1751

  #Descripción: Login Portal Wallet Provider - mostrar respuesta al logarse mediante autentica
  #Pasos:
  #1. El usuario accede al Portal de Administración de Pid Provider de Cartera Digital mediante una url válida.
  #2. El usuario accede a la pantalla de Prelogin.
  #3. El usuario inicia sesión mediante su certificado electrónico a través de autentica con un rol ejecutivo.
  #4. Leer y aceptar los terminos y condiciones
  #5. El usuario accede a la pantalla de inicio.

  @WALLET-1751
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Leer el texto de los términos y condiciones
    And Aceptar los términos y condiciones
    And Cerrar el navegador

