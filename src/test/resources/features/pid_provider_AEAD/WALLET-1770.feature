Feature: WALLET-1770

  @WALLET-1770

  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Revocación por archivo - mostrar respuesta tras revocación de credenciales seleccionadas al cargar un archivo
    Given Abrir la web PID provider
    When Click en el botón revocacion por archivo
    Then Click en el boton elige tu archivo

