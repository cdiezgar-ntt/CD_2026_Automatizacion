Feature: WALLET-1759

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de credencial – Credencial revocable - mostrar respuesta de detalle de credencial revocable
    Given Abrir la web PID provider
    When Click en el botón acceder
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocable"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle cartera revocada
    And Cerrar el navegador

