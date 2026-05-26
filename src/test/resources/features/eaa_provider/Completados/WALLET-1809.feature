Feature: WALLET-1809

  @Portal_EAA
Scenario: EAA PROVIDER - CONSULTIVO - Pantalla inicio - búsqueda de credenciales con filtros
    Given Abrir la web EAA provider
    When Click en el botón acceder
    And Seleccionar en el combo con id "eaa_comboFiltroEstado" la opcion con valor "ACTIVE"
    And Click en el botón buscar
    And Click en el primer elemento de la lista EAA
    Then Validar el estado de la credencial "válida"


