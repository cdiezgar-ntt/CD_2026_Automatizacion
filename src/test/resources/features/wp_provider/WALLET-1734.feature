Feature: WALLET-1734
#Descripción: Histórico de revocación - mostrar respuesta de bloques y detalle del histórico de revocación en proceso
  #Pasos:
  #1. Tras autenticarse en el Portal Administración con un certificado electrónico válido el usuario y aceptar los términos y condiciones del Wallet Provider, el usuario accede a la pantalla de inicio del Portal.
  #2. El usuario accede a la pantalla “Histórico de revocación” a través de un enlace en el header.
  #3. La pantalla lleva al usuario a la pantalla de bloque de histórico de revocación.
  #4. El usuario puede acceder a través de “Acción” al detalle de cada bloque de revocación. En este caso accederá a un bloque con estado “En proceso”.
  #5. Se redirige al usuario a la pantalla de detalle de bloque de revocación.

  #Etiquetas
  @WALLET-1734 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Histórico de revocación - mostrar respuesta de bloques y detalle del histórico de revocación en proceso
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el link Historico Revocaciones
    And Esperar 5 segundos
    And Validar que el campo "wp_historicoRevocacion_titulo" de tipo "xpath" tiene el valor "Histórico revocación"
    And Validar que el campo "wp_hitoricoRevocacion_TablaEstado" de tipo "xpath" tiene el valor "Revocada"
    And Click en el primer elemento de la lista
    And Validar que el campo "wp_detalleHistoricoRevocacion_titulo" de tipo "xpath" tiene el valor "Detalle bloque revocación"
    And Validar que el campo "wp_detalleHitoricoRevocacion_TablaEstado" de tipo "tag" tiene el valor "Revocada"
    And Cerrar el navegador
