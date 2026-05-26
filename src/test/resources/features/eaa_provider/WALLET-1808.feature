Feature: WALLET-1808

  @TC_01
Scenario: EAA PROVIDER - CONSULTIVO - Pantalla inicio - mostrar respuesta de información destacada y búsqueda de credenciales sin filtros
    Given Abrir la web EAA provider
  #  When Click en el botón acceder
    When Click en el botón buscar
    Then Validar que el numero de credenciales tenga un numero mayor que 0
  #  No se puede ejecutar la validacion ya que la busqueda da error


