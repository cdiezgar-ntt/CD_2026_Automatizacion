Feature: WALLET-1760

  @WALLET-1760
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de credencial – Credencial revocable - revocar credencial a través del detalle de credencial revocable
    Given Abrir la web PID provider
    When Seleccionar en el combo estado credencial la opcion con valor "ACTIVE"
    When Click en el botón buscar PID
    And Click en el primer elemento de la lista de credenciales
    And Esperar 5 segundos
    And Validar que el campo informacion general estado credencial tiene el valor "Válida"
    And Click en el botón revocar credencial
    And Seleccionar en el combo motivo revocacion PID la opcion con valor "Otros motivos"
    When Click en el botón confirmar revocación PID
    And Acepta la alerta de autofirma
    When Selecciona su certificado en autofirma
    And Esperar 5 segundos
