Feature: WALLET-1769

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocar credenciales seleccionadas - mostrar respuesta de error tras revocación de credenciales seleccionadas
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle PID activas ultimo mes
    And  Seleccionar PID de la lista
    And  Pulsar el botón revocar seleccionadas
    When Seleccionar el motivo
