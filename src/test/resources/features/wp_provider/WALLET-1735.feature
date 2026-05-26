Feature: WALLET-1735
#Descripción: Histórico de revocación - reintentar revocar carteras fallidas en el detalle de histórico de revocación
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. El usuario accede a la pantalla “Histórico de revocación” a través de un enlace en el header.
  #3. La pantalla lleva al usuario a la pantalla de bloque de histórico de revocación.
  #4. El usuario puede acceder a través de “Acción” al detalle de cada bloque de revocación. En este caso accederá a un bloque con estado “Error”
  #5. Se redirige al usuario a la pantalla de detalle de bloque de revocación de error.
  #6. El usuario pulsa en el botón “Reintentar fallidas”.
  #7. La pantalla muestra una modal en la que se indica el número de Carteras que va a revocar.
  #8. El usuario indica el motivo de revocación y confirma en “Sí, revocar”.
  #9. La pantalla muestra un mensaje de confirmación del proceso de revocación y el usuario puede volver al inicio o ir a la pantalla de detalle de la revocación.

  #Etiquetas
  @WALLET-1735 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Histórico de revocación - reintentar revocar carteras fallidas en el detalle de histórico de revocación
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en botón historico de revocacion - portal wallet provider
    And Click en en boton accion del bloque error - portal wallet provider
    And Navega a pantalla de detalle de bloque de revocacion - portal wallet provider
    And Click en el boton reintentar revocar - portal wallet provider
    And Cerrar el navegador