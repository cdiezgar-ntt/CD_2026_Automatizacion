Feature: WALLET-1728

  @TC_01
Scenario: WALLET PROVIDER - EJECUTIVO - Revocar carteras seleccionadas - mostrar respuesta de error tras revocación de carteras seleccionadas
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
    And Comprobación del modal de error de revocación de carteras seleccionadas
    And Cerrar el navegador
