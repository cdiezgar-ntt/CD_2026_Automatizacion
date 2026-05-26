Feature: WALLET-1757

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Credencial revocada - mostrar respuesta de detalle de credencial revocada
    Given Abrir la web PID provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Seleciono el combo tipo credencial el valor "Revocada"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle pid revocada
    And Cerrar el navegador

