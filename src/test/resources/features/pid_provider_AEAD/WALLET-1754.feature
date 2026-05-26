Feature: WALLET-1754

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - búsqueda de Credenciales con filtros
    Given Abrir la web PID provider
    When Click en el botón acceder
    When Rellenar el texto "50649281S" en el campo de búsqueda DNI/NIE
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    Then Validar que el campo "pid_dniFiltro" de tipo "xpath" tiene el valor "50649281S"
    And Cerrar el navegador

