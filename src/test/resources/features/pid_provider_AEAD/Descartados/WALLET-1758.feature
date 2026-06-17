Feature: WALLET-1758

  @WALLET-1758
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Credencial revocada - mostrar respuesta de error en el detalle de credencial revocada
    Given Abrir la web PID provider
    When Click en el botón acceder
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocada"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar error en detalle cartera revocada
    And Cerrar el navegador


