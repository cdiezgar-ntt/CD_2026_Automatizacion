Feature: WALLET-1755

  @WALLET-1755
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - búsqueda de Credenciales sin resultados
    Given Abrir la web PID provider
    Given Rellenar el texto "79194371M" en el campo de busqueda DNI
    When Click en el botón buscar PID
    And Esperar 5 segundos
    And Cerrar el navegador
