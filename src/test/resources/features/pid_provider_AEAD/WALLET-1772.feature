Feature: WALLET-1772

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocación por archivo - error de formato al cargar un archivo
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón detalle PID activas ultimo mes
    And  Seleccionar PID de la lista
    And  Pulsar el botón revocar seleccionadas
    When Seleccionar el motivo
    And  Adjuntar el arhivo de revocacion con formato incorrecto
