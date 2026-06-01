Feature: WALLET-1898
    Background:
        Given Abrir la web usuario
        And El usuario pulsa en Revocar Cartera Digital
        And El usuario introduce el mail "gdd@chf.vh"
        And El usuario pulsa en Enviar
        Then Los digitos estan habilitados
        When El usuario introduce el código de verificación recibido
        And El usuario pulsa en Continuar Revocación

    @WALLET-1898
Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Aceptar términos y condiciones - cancelar términos y condiciones
        When El usuario marca el check para aceptar terminos y condiciones
        Then El botón Cancelar de los terminos y condiciones está habilitado
        When El usuario marca el check para aceptar terminos y condiciones
        Then El botón Cancelar de los terminos y condiciones está habilitado
        When El usuario cancela los terminos y condiciones
        Then Se carga el paso 1 de la revocación
