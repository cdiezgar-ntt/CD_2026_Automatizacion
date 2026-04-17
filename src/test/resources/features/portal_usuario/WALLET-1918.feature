Feature: WALLET-1918

  @TC_01
  Scenario: PORTAL USUARIO - REVOCACIÓN PRESENCIAL - Opciones de revocación y botón idiomas
    Given Abrir la web "https://pre-citizen-cd.redsara.es/control-panel/"
    Then El usuario visualiza 3 tipos de revocación
    And El usuario visualiza la opción de revocación "Revocación total de Cartera Digital"
    And El usuario visualiza la opción de revocación "Revocación de tu credencial de Identidad Digital online"
    And El usuario visualiza la opción de revocación "Revocación presencial"
    When El usuario pulsa en consultar oficina
    Then El usuario accede a una pantalla con las oficinas
    And El usuario ve las oficinas para revocar la Cartera Digital
    And El usuario ve las oficinas para revocar la PID
    And Existe un botón para cambiar a varios idiomas

  Scenario Outline: PORTAL USUARIO - REVOCACIÓN PRESENCIAL - Traducción flujo Revocación Presencial - <idioma>
    Given Abrir la web "https://pre-citizen-cd.redsara.es/control-panel/"
    When El usuario pulsa en consultar oficina
    When El usuario cambia al idioma "<idioma>"
    Then El texto para revocar la cartera está en el "<idioma>" y es "<texto_revocar_cartera>"
    Then El texto para revocar la PID está en el "<idioma>" y es "<texto_revocar_PID>"

    Examples:
      | idioma   | texto_revocar_cartera       | texto_revocar_PID                         |
      | English  | Revoke Digital Wallet       | Revoke Identidad Digital credential       |
      | Català   | Revocar Cartera Digital     | Revocar credencial d’Identidad Digital    |
      | Euskara  | Errebolatu kartera digitala | Errebolatu Identidad Digital kredentziala |
      | Galego   | Revogar carteira dixital    | Revogar credencial de Identidad Digital   |
      | Valencià | Revocar Cartera Digital     | Revocar credencial d'Identidad Digital    |
      | Español  | Revocar Cartera Digital     | Revocar credencial de Identidad Digital   |