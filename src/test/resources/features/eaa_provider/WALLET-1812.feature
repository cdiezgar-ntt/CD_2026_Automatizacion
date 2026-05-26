Feature: WALLET-1812

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Filtro tipo credenciales en información destacada - mostrar respuesta de información destacada tras cambiar el tipo de credencial a las diferentes opciones
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Seleciono el combo tipo credencial el valor "Revocacion a traves del sistema automatico"
    When Click en el botón buscar
    And Esperar 5 segundos
    Then Validar que el campo "estado" de tipo "xpath" tiene el valor "Revocada"