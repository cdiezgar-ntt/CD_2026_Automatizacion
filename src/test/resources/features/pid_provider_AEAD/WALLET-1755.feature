Feature: WALLET-1755

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - búsqueda de Credenciales sin resultados
    Given Abrir la web PID provider
    When Click en el botón acceder
    When Añado el texto "123456789" en el campo de búsqueda ""
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Cerrar el navegador

