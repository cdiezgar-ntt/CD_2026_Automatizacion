Feature: WALLET-1891

  @portal_usuario @idiomas
  Scenario Outline: PORTAL USUARIO - INICIO - Traducción Landing portal usuario - traducción landing portal usuario - <idioma>
    Given Abrir la web usuario
    Then Existe un botón para cambiar a varios idiomas
    When El usuario cambia al idioma "<idioma>"
    Then El titulo de la home es "<titulo_home>"
    And Los enlaces son "<titulo_accesibilidad>", "<titulo_mapaWeb>", "<titulo_avisoLegal>", "<titulo_politicaPrivacidad>", "<titulo_politicaCookies>"
    When El usuario pulsa en accesibilidad
    Then Se carga la pagina de "<titulo_accesibilidad>"
    When El usuario vuelve a la home
    And El usuario pulsa en mapa web
    Then Se carga la pagina de "<titulo_mapaWeb>"
    When El usuario vuelve a la home
    And El usuario pulsa en aviso legal
    Then Se carga la pagina de "<titulo_avisoLegal>"
    When El usuario vuelve a la home
    And El usuario pulsa en politica de privacidad
    Then Se carga la pagina de "<titulo_politicaPrivacidad>"
    When El usuario vuelve a la home
    And El usuario pulsa en política de cookies
    Then Se carga la pagina de "<titulo_politicaCookies>"


    Examples:
      | idioma   | titulo_home                                                                |  titulo_accesibilidad | titulo_mapaWeb | titulo_avisoLegal | titulo_politicaPrivacidad | titulo_politicaCookies |
      | English  | Manage access to Cartera Digital, protect access to your data              |  Accessibility        | Site map       | Legal Notice      | Privacy Policy            | Cookies policy         |
      | Català   | Gestiona l’accés a la Cartera Digital, protegeix l’accés a les teves dades |  Accessibilitat       | Mapa del lloc  | Avís Legal        | Política de Privacitat    | Política de cookies    |
      | Euskara  | Kudeatu Cartera Digital-erako sarbidea, babestu zure datuetarako sarbidea  |  Irisgarritasuna      | Web mapa       | Lege Oharra       | Pribatutasun Politika     | Cookieen politika      |
      | Galego   | Xestiona o acceso á Cartera Digital, protexe o acceso aos teus datos       |  Accesibilidade       | Mapa web       | Aviso Legal       | Política de Privacidade   | Política de cookies    |
      | Valencià | Gestiona l'accés a la Cartera Digital, protegix l'accés a les teues dades  |  Accessibilitat       | Mapa web       | Avís Legal        | Política de Privacitat    | Política de cookies    |
      | Español  | Gestiona el acceso a Cartera Digital, protege el acceso a tus datos        |  Accesibilidad        | Mapa web       | Aviso Legal       | Política de Privacidad    | Política de cookies    |

