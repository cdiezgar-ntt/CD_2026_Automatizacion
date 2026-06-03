Feature: WALLET-1897
    Background:
        Given Abrir la web usuario
        And El usuario pulsa en Revocar Cartera Digital
        And El usuario introduce el mail "pruebasqa_cdg@email.com"
        And El usuario pulsa en Enviar
        Then Los digitos estan habilitados
        When El usuario introduce el código de verificación recibido
        And El usuario pulsa en Continuar Revocación

    @portal_usuario @revocacion @terminos_condiciones
    Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Aceptar términos y condiciones - mostrar respuesta al aceptar los términos y condiciones
        When El usuario marca el check para aceptar terminos y condiciones
        Then Se habilita el botón Confirmar de los terminos y condiciones
        When El usuario confirma los terminos y condiciones
        Then Se carga el paso 3 de la revocación