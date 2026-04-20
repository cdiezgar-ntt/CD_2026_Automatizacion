Feature: WALLET-1918

  @TC_01
  Scenario Outline: PORTAL USUARIO - REVOCACIÓN PRESENCIAL - Traducción flujo Revocación Presencial - <idioma>
    Given Abrir la web "https://pre-citizen-cd.redsara.es/control-panel/"
    Then Existe un botón para cambiar a varios idiomas
    When El usuario pulsa en consultar oficina
    Then El usuario accede a una pantalla con las oficinas
    When El usuario cambia al idioma "<idioma>"
    Then El usuario ve las oficinas para revocar la cartera está en el "<idioma>" y es "<texto_revocar_cartera>"
    Then El usuario ve las oficinas para revocar la PID está en el "<idioma>" y es "<texto_revocar_PID>"

    Examples:
      | idioma   | texto_revocar_cartera       | texto_revocar_PID                         |
      | English  | Revoke Digital Wallet       | Revoke Identidad Digital credential       |
      | Català   | Revocar Cartera Digital     | Revocar credencial d’Identidad Digital    |
      | Euskara  | Errebolatu kartera digitala | Errebolatu Identidad Digital kredentziala |
      | Galego   | Revogar carteira dixital    | Revogar credencial de Identidad Digital   |
      | Valencià | Revocar Cartera Digital     | Revocar credencial d'Identidad Digital    |
      | Español  | Revocar Cartera Digital     | Revocar credencial de Identidad Digital   |