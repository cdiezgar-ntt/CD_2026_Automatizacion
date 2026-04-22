Feature: WALLET-1885

@portal_usuario @home
Scenario: PORTAL USUARIO - INICIO - Landing portal usuario - visualizar preguntas frecuentes
    Given Abrir la web usuario
    Then El usuario ve una sección de preguntas frecuentes
    And Hay al menos una pregunta frecuente
    And Las respuestas están ocultas
    When El usuario despliega las preguntas frecuentes
    Then Las preguntas frecuentes tienen respuesta
    When El usuario pliega las preguntas frecuentes
    Then Las respuestas están ocultas