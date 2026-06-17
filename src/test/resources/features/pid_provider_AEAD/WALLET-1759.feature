Feature: WALLET-1759

  @WALLET-1759
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de credencial – Credencial revocable - mostrar respuesta de detalle de credencial revocable
    Given Abrir la web PID provider
    When Seleccionar en el combo estado credencial la opcion con valor "ACTIVE"
    When Click en el botón buscar PID
    And Click en el primer elemento de la lista de credenciales
    And Esperar 5 segundos
    And Validar que el campo informacion general estado credencial tiene el valor "Válida"
    And Esperar 5 segundos
    And Cerrar el navegador


