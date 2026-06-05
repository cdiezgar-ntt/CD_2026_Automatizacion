Feature: WALLET-1728-XXXXX
#Descripción: Revocar carteras seleccionadas - mostrar respuesta de error tras revocación de carteras seleccionadas
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. La pantalla muestra la información destacada sobre las Carteras: carteras activas, activadas y revocadas
  #3. El usuario pulsa en el botón “Buscar” que se encuentra debajo de la información destacada.
  #4. La pantalla muestra todas las carteras sin filtrar.
  #5. El usuario selecciona las carteras activadas que desee y pulsa en el botón “Revocar seleccionadas”.
  #6. La pantalla mostrará una modal en la que el usuario introduce el motivo de revocación y pulsa en “Sí, revocar”.
  #7. La modal mostrará un mensaje de error en el caso de que alguna de las Carteras haya dado error al revocarla y el usuario tendrá la opción de ver el resumen de revocación o de volver al inicio.

  #Etiquetas
  @WALLET-1728 @wallet_provider @noejecutar @wp_descartado
Scenario: WALLET PROVIDER - EJECUTIVO - Revocar carteras seleccionadas - mostrar respuesta de error tras revocación de carteras seleccionadas
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocables"
    When Click en el botón buscar - portal wallet provider
    And Click en la primera cartera de la lista - portal wallet provider
    And Click en la segunda cartera de la lista - portal wallet provider
    And Click en la tercera cartera de la lista - portal wallet provider
    When Click en el botón revocar - portal wallet provider
    And Seleccionar motivo de revocación "Motivo de revocación 1" - portal wallet provider
    And Click en el botón confirmar revocación - portal wallet provider
    And Comprobación del modal de error de revocación de carteras seleccionadas - portal wallet provider
    And Cerrar el navegador
