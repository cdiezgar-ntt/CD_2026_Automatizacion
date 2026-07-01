Feature: WALLET-1772

  @WALLET-1772
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocación por archivo - error de formato al cargar un archivo
    Given Abrir la web PID provider
    When Click en el botón revocacion por archivo
    Then Click en el boton elige tu archivo
    Given Seleccionar el archivo de revocacion
