Feature: WALLET-1817

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Detalle de presentación de credencial con error - mostrar respuesta de detalle de credencial con error
    Given Abrir la web "https://pre-eaa-cd.redsara.es/auth/login"
    And Esperar 5 segundos
    When Click en el botón acceder
    And Esperar 5 segundos
    When Seleciono el combo estado "Suspendida"
    When Click en el botón buscar
    And Esperar 5 segundos
    Then Validar que tiene un error la credencial

