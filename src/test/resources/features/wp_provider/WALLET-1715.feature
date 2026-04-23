Feature: WALLET-1715

  @WALLET-1715 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de Carteras sin filtros
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Cerrar el navegador