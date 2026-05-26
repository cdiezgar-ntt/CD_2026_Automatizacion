Feature: WALLET-1760

  @TC_01
Scenario: PID PROVIDER (AEAD) - EJECUTIVO - Detalle de credencial – Credencial revocable - revocar credencial a través del detalle de credencial revocable

    Given Abrir la web PID provider
    When Click en el botón acceder
    When Seleciono el combo tipo credencial el valor "Activa"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle credencial activa
    And Click en el botón revocar credencial
    And Seleccionar motivo de revocación "Pérdida o robo del dispositivo"
    And Click en el botón confirmar revocación
    And Cerrar el navegador

