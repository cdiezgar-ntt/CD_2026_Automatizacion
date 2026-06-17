Feature: WALLET-1757

  @WALLET-1757
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Credencial revocada - mostrar respuesta de detalle de credencial revocada
    Given Abrir la web PID provider
    When Seleccionar en el combo estado credencial la opcion con valor "REVOKED"
    When Click en el botón buscar PID
    And Click en el primer elemento de la lista de credenciales
    And Esperar 5 segundos
    And Validar que el campo informacion general estado credencial tiene el valor "Revocada"
    And Esperar 5 segundos
    And Cerrar el navegador

