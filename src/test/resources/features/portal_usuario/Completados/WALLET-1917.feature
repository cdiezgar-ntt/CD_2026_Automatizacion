Feature: WALLET-1917

@portal_usuario @presencial
Scenario: PORTAL USUARIO - REVOCACIÓN PRESENCIAL - Revocación presencial - mostrar respuesta al acceder a Revocación presencial
    Given Abrir la web usuario
    When El usuario pulsa en consultar oficina
    Then El usuario accede a una pantalla con las oficinas
    And El usuario visualiza oficinas

