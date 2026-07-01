Feature: WALLET-1768

  @WALLET-1768
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocar credenciales seleccionadas - mostrar respuesta tras revocación de credenciales seleccionadas
    Given Abrir la web PID provider
    When Click en el botón ver todas pid activas ultimo mes
    And  Seleccionar PID de la lista
    And Esperar 5 segundos
    And  Pulsar el botón revocar seleccionadas
    And Seleccionar en el combo motivo revocacion PID la opcion con valor "Otros motivos"
    When Click en el botón confirmar revocación PID
    And Acepta la alerta de autofirma
    When Selecciona su certificado en autofirma

