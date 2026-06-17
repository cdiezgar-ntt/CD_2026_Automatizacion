Feature: WALLET-1753

  @WALLET-1753
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de Credenciales sin filtros
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Esperar 5 segundos
    And Cerrar el navegador

