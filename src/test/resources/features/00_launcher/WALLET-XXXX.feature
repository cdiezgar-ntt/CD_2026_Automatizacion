Feature: WALLET-XXXX

  @Test1Apis
  Scenario: Test
    When envío una petición "GET" al endpoint "/pokemon/1" sin body
    Then el código de respuesta debe ser 200
    And compruebo que el campo "forms[0].name" tiene el valor "bulbasaur"