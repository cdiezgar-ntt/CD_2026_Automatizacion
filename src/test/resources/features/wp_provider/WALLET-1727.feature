Feature: WALLET-1727

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Revocar carteras seleccionadas - mostrar respuesta tras revocación de carteras seleccionadas

    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Añado el texto "XXXXXXXXX" en el campo de búsqueda "revocables"
    When Click en el botón buscar
    And Click en la primera cartera de la lista
    And Click en la segunda cartera de la lista
    And Click en la tercera cartera de la lista
    When Click en el botón revocar
    And Seleccionar motivo de revocación "Motivo de revocación 1"
    And Click en el botón confirmar revocación
    And Comprobar revocación de carteras seleccionadas
    And Cerrar el navegador