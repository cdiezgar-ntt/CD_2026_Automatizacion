Feature: WALLET-1901
    Background:
        Given Abrir la web usuario
        And El usuario pulsa en Revocar Cartera Digital
        And El usuario introduce el mail "carlosqa3@email.com"
        And El usuario pulsa en Enviar
        Then Los digitos estan habilitados
        When El usuario introduce el código de verificación recibido
        And El usuario pulsa en Continuar Revocación
        And El usuario marca el check para aceptar terminos y condiciones
        And El usuario confirma los terminos y condiciones
        Then Se carga el paso 3 de la revocación

    @WALLET-1901
    Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Aceptar términos y condiciones - mostrar respuesta al revocar la Cartera correctamente y volver al inicio - Firma básica
        When El usuario despliega los motivos de revocacion
        And El usuario elige el motivo "Cambio de datos de identidad"
        When El usuario selecciona firma básica
        Then Se desbloquea el botón continuar revocación
        When El usuario pulsa en Continuar Revocación
        Then Se muestra el resumen del proceso con el resultado de la revocacion
        When El usuario pulsa en volver al inicio
        Then El usuario visualiza 3 tipos de revocación
        # Validacion de que se ha revocado realmente desde el Wallet provider
        When Abrir la web wallet provider
        And Click en el botón acceder
        And Rellenar el texto "carlosqa3@email.com" en el campo de busqueda email - portal wallet provider
        And Click en el botón buscar - portal wallet provider
        And Click en el primer elemento de la lista - portal wallet provider
        Then El estado de la cartera es "Revocada"

    # Pendiente scenario con firma autofirma