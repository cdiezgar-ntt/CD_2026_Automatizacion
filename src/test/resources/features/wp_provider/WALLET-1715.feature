Feature: WALLET-1715
#Descripción: Pantalla inicio - mostrar respuesta de información destacada y búsqueda de Carteras sin filtros
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.

  #Etiquetas
  @WALLET-1715 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de Carteras sin filtros
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar
    And Obtener primer correo
    #And Click en el primer elemento de la lista - portal wallet provider
    And Cerrar el navegador