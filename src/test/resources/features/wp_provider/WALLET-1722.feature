Feature: WALLET-1722

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Detalle de Cartera – Cartera revocable - revocar cartera a través del detalle de cartera revocable
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocable"
    When Click en el botón buscar
    And Click en el primer elemento de la lista
    And Comprobar detalle cartera revocada
    And Click en el botón revocar cartera
    And Seleccionar motivo de revocación "Pérdida o robo del dispositivo"
    And Click en el botón confirmar revocación
    And Cerrar el navegador
