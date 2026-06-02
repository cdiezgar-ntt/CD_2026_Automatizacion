Feature: WALLET-1901


    Background:
        Given El usuario dispone de una cartera valida
        And Abrir la web usuario
        And El usuario pulsa en Revocar Cartera Digital
        And El usuario introduce el mail de la cartera
        And El usuario pulsa en Enviar
        Then Los digitos estan habilitados
        When El usuario introduce el código de verificación recibido
        And El usuario pulsa en Continuar Revocación
        And El usuario marca el check para aceptar terminos y condiciones
        And El usuario confirma los terminos y condiciones
        Then Se carga el paso 3 de la revocación
        When El usuario despliega los motivos de revocacion
        And El usuario elige el motivo "Cambio de datos de identidad"


    @WALLET-1901
    # Pendiente scenario con firma autofirma
    Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Aceptar términos y condiciones - mostrar respuesta al revocar la Cartera correctamente y volver al inicio - Autofirma
        When El usuario selecciona autofirma
        Then Se desbloquea el botón continuar revocación
        When El usuario pulsa en Continuar Revocación
        And Acepta la alerta de autofirma
        And Selecciona su certificado en autofirma
        Then Se muestra el resumen del proceso con el resultado de la revocacion
        When El usuario pulsa en volver al inicio
        Then El usuario visualiza 3 tipos de revocación
        When Abrir la web wallet provider
        And Click en el botón acceder
        And El usuario escribe un email existente
        And Click en el botón buscar - portal wallet provider
        And Click en el primer elemento de la lista - portal wallet provider
        Then El estado de la cartera es "Revocada"

    @WALLET-1901
    Scenario: PORTAL USUARIO - REVOCACIÓN CARTERA DIGITAL - Aceptar términos y condiciones - mostrar respuesta al revocar la Cartera correctamente y volver al inicio - Firma básica
        When El usuario selecciona firma básica
        Then Se desbloquea el botón continuar revocación
        When El usuario pulsa en Continuar Revocación
        Then Se muestra el resumen del proceso con el resultado de la revocacion
        When El usuario pulsa en volver al inicio
        Then El usuario visualiza 3 tipos de revocación
        When Abrir la web wallet provider
        And Click en el botón acceder
        And El usuario escribe un email existente
        And Click en el botón buscar - portal wallet provider
        And Click en el primer elemento de la lista - portal wallet provider
        Then El estado de la cartera es "Revocada"