Feature: WALLET-1717
#Descripción: Pantalla inicio - búsqueda de Carteras sin resultados
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra un mensaje indicando que no existen Carteras para los filtros seleccionados.

  #Etiquetas
  @WALLET-1717 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras sin resultados
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Rellenar el texto "1234567" en el campo de busqueda email
    When Click en el botón buscar
    And Validar que el campo sin resultado tiene el valor "Sin resultados"
    And Validar que el campo descripcion sin resultado tiene el valor "Revisa o ajusta los filtros y los criterios de búsqueda para mostrar más resultados."
    And Cerrar el navegador