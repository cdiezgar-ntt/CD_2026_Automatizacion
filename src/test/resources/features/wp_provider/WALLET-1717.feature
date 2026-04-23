Feature: WALLET-1717

  @WALLET-1717 @wallet_provider
  Scenario: WALLET PROVIDER - EJECUTIVO - Pantalla inicio - búsqueda de Carteras sin resultados
    Given Abrir la web wallet provider
    And Esperar 5 segundos
    When Click en el botón acceder
    And  Intro en certificado
    When Rellenar el texto "1234567" en el campo de busqueda email
    When Click en el botón buscar
    And Validar que el campo "wp_pantallaInicio_SinResultados" de tipo "xpath" tiene el valor "Sin resultados"
    And Validar que el campo "wp_pantallaInicio_SinResultados_descripcion" de tipo "xpath" tiene el valor "Revisa o ajusta los filtros y los criterios de búsqueda para mostrar más resultados."
    And Cerrar el navegador