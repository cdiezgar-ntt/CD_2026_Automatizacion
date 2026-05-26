Feature: WALLET-1753

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de Credenciales sin filtros
    Given Abrir la web PID provider
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Cerrar el navegador

