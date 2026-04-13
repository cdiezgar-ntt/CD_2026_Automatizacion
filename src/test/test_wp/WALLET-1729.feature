Feature: WALLET-1729

  @TC_02
  Scenario: WALLET PROVIDER - EJECUTIVO - Revocación por archivo - mostrar respuesta tras revocación de carteras seleccionadas al cargar un archivo
    Given Abrir la web "https://pre-wp-cd.redsara.es/control-panel/"
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Click en el botón buscar
    And Cerrar el navegador