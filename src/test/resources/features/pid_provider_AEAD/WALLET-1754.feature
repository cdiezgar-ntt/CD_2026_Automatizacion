Feature: WALLET-1754

  @WALLET-1754
  Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - búsqueda de Credenciales con filtros
    Given Abrir la web PID provider
    Given Rellenar el texto "79194371N" en el campo de busqueda DNI
    When Click en el botón buscar PID
    And Click en el primer elemento de la lista de credenciales
    Then Validar que el campo dni del filtro tiene el valor "79194371N"
    And Cerrar el navegador

