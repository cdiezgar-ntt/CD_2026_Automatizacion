Feature: WALLET-1761

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de credencial – Credencial revocable - mostrar respuesta de error en el detalle de credencial revocable
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleciono el combo tipo credencial el valor "Activa"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar error en detalle cartera revocable
    And Cerrar el navegador

