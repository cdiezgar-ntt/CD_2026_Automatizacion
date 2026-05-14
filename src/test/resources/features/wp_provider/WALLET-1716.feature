Feature: WALLET-1716
#Descripción: Pantalla inicio - búsqueda de Carteras con filtros
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario establece unos filtros determinados y pulsa en el botón “Buscar”.
  #4. La pantalla muestra las carteras en base a los filtros seleccionados.

  #Etiquetas
  @WALLET-1716 @wallet_provider @inicio
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras con filtros
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Rellenar el texto "alberto.sanchez.tsol@gmail.com" en el campo de busqueda email - portal wallet provider
    When Click en el botón buscar - portal wallet provider
    And Click en el primer elemento de la lista - portal wallet provider
    And Validar que el campo "wp_detalleCartera_InformacionContacto_email" de tipo "xpath" tiene el valor "alberto.sanchez.tsol@gmail.com"
    And Cerrar el navegador