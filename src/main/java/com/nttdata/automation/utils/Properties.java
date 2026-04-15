package com.nttdata.automation.utils;

public class Properties {

    //######WALLET PROVIDER PATHS
    //##Control Panel
    public String pantallaLogin_BotonAcceder;
    public String wp_pantallaInicio_BotonBuscar;
    public String wp_pantallaInicio_PrimerElementoTabla;
    public String wp_pantallaInicio_textBoxEmail;
    public String wp_pantallaInicio_textBoxIdCartera;
    public String wp_pantallaInicio_textBoxTelefono;
    public String wp_pantallaInicio_ComboEstado;
    public String wp_pantallaInicio_ComboFechaActivacion;
    public String wp_pantallaInicio_ComboFechaRevocacion;
    public String wp_pantallaInicio_ComboMotivoRevocacion;
    public String wp_pantallaInicio_ComboMedioSolicitudRevocacion;
    public String wp_pantallaInicio_CheckMostrarSoloMisRevocaciones;
    public String wp_pantallaInicio_MostrarBusquedaAvanzada;
    public String wp_pantallaInicio_OcultarBusquedaAvanzada;
    public String wp_pantallaInicio_primerElementoTablaBusquedaEmail;
    public String wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas;
    public String wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas;
    public String wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas;
    public String wp_pantallaInicio_HistoricoRevocacion;
    //##Control Panel - Revocacion
    public String wp_pantallaInicio_Revocacion_BtnRevocar;
    public String wp_pantallaInicio_Revocacion_MotivoRevocacion;
    public String wp_pantallaInicio_Revocacion_BtnSiRevocar;
    public String wp_pantallaInicio_Revocacion_BtnCancelar;
    //##Detalles cartera
    public String wp_detalleCartera_volverAInicio;
    public String wp_detalleCartera_botonRevocarCartera;
    public String wp_detalleCartera_InformacionGeneral_IdCartera;
    public String wp_detalleCartera_InformacionGeneral_estado;
    public String wp_detalleCartera_InformacionGeneral_fechaActivacion;
    public String wp_detalleCartera_InformacionContacto_email;
    public String wp_detalleCartera_InformacionContacto_telefono;
    public String wp_detalleCartera_informacionAdicionalCartera_SO;
    public String wp_detalleCartera_informacionAdicionalCartera_versionAPP;
    public String wp_detalleCartera_informacionAdicionalCartera_versionTandC;
    public String wp_detalleCartera_RevocarCartera_ComboMotivoRevocacion;
    public String wp_detalleCartera_RevocarCartera_SiRevocar;
    public String wp_detalleCartera_RevocarCartera_CancelarRevocacion;
    //##Carteras Activadas Ultimo Mes
    public String wp_carterasActivadasUltimoMes_verTodas;
    public String wp_carterasActivadasUltimoMes_primerElementoTabla;
    //##Carteras Activas Ultimo Mes

    //##Carteras Revocadas Ultimo Mes

    //PID Provider PATHS

    //EAA Provider PATHS

    //Portal Usuario PATHS
    //##Navegación inferior
    public String cit_home_titulopantallaenlace;
    public String cit_home_accesibilidad;
    public String cit_home_avisolegal;
    public String cit_home_mapaweb;
    public String cit_home_politicaprivacidad;
    public String cit_home_politicadecookies;


    public static PropertiesManager pm = new PropertiesManager();

    public void read(){

        //######WALLET PROVIDER PATHS
        //##Control Panel
        System.out.println("Leyendo valores de properties para pantalla principal...");
        pantallaLogin_BotonAcceder = pm.readPropertiesPantallaInicio("pantallaLogin_BotonAcceder");
        System.out.println("Valor leído para pantallaLogin_Acceder: " + pantallaLogin_BotonAcceder);
        wp_pantallaInicio_BotonBuscar = pm.readPropertiesPantallaInicio("wp_pantallaInicio_BotonBuscar");
        System.out.println("Valor leído para wp_pantallaInicio_BotonBuscar: " + wp_pantallaInicio_BotonBuscar);
        wp_pantallaInicio_PrimerElementoTabla = pm.readPropertiesPantallaInicio("wp_pantallaInicio_PrimerElementoTabla");
        System.out.println("Valor leído para wp_pantallaInicio_PrimerElementoTabla: " + wp_pantallaInicio_PrimerElementoTabla);
        wp_pantallaInicio_textBoxEmail = pm.readPropertiesPantallaInicio("wp_pantallaInicio_textBoxEmail");
        System.out.println("Valor leído para wp_pantallaInicio_textBoxEmail: " + wp_pantallaInicio_textBoxEmail);
        wp_pantallaInicio_primerElementoTablaBusquedaEmail = pm.readPropertiesPantallaInicio("wp_pantallaInicio_primerElementoTablaBusquedaEmail");
        System.out.println("Valor leído para wp_pantallaInicio_primerElementoTablaBusquedaEmail: " + wp_pantallaInicio_primerElementoTablaBusquedaEmail);
        //wp_pantallaInicio_BotonBuscarEmail = pm.readPropertiesPantallaInicio("wp_pantallaInicio_BotonBuscarEmail");
        //System.out.println("Valor leído para wp_pantallaInicio_BotonBuscarEmail: " + wp_pantallaInicio_BotonBuscarEmail);
        wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas = pm.readPropertiesPantallaInicio("wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas");
        System.out.println("Valor leído para wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas: " + wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas);
        wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas = pm.readPropertiesPantallaInicio("wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas");
        System.out.println("Valor leído para wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas: " + wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas);
        wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas = pm.readPropertiesPantallaInicio("wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas");
        System.out.println("Valor leído para wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas: " + wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas);
        wp_pantallaInicio_HistoricoRevocacion = pm.readPropertiesPantallaInicio("wp_pantallaInicio_HistoricoRevocacion");
        System.out.println("Valor leído para wp_pantallaInicio_HistoricoRevocacion: " + wp_pantallaInicio_HistoricoRevocacion);
        //##Detalles cartera

        //PID Provider PATHS

        //EAA Provider PATHS

        //Portal Usuario PATHS
        cit_home_accesibilidad = pm.readPropertiesPantallaInicio("cit_home_accesibilidad");
        System.out.println("Valor leído para cit_home_accesibilidad: " + cit_home_accesibilidad);
        cit_home_avisolegal = pm.readPropertiesPantallaInicio("cit_home_avisolegal");
        System.out.println("Valor leído para cit_home_avisolegal: " + cit_home_avisolegal);
        cit_home_mapaweb = pm.readPropertiesPantallaInicio("cit_home_mapaweb");
        System.out.println("Valor leído para cit_home_mapaweb: " + cit_home_mapaweb);
        cit_home_politicaprivacidad = pm.readPropertiesPantallaInicio("cit_home_politicaprivacidad");
        System.out.println("Valor leído para cit_home_politicaprivacidad: " + cit_home_politicaprivacidad);
        cit_home_politicadecookies = pm.readPropertiesPantallaInicio("cit_home_politicadecookies");
        System.out.println("Valor leído para cit_home_politicadecookies: " + cit_home_politicadecookies);
        cit_home_titulopantallaenlace= pm.readPropertiesPantallaInicio("cit_home_titulopantallaenlace");
        System.out.println("Valor leído para cit_home_politicadecookies: " + cit_home_titulopantallaenlace);



    }

    //######WALLET PROVIDER Getter y Setter
    //##Control Panel
    public String getPantallaLogin_BotonAcceder() {
        return pantallaLogin_BotonAcceder;
    }

    public void setPantallaLogin_BotonAcceder(String pantallaLogin_BotonAcceder) {
        this.pantallaLogin_BotonAcceder = pantallaLogin_BotonAcceder;
    }

    public String getwp_pantallaInicio_BotonBuscar() {
        return wp_pantallaInicio_BotonBuscar;
    }

    public void setwp_pantallaInicio_BotonBuscar(String wp_pantallaInicio_BotonBuscar) {
        this.wp_pantallaInicio_BotonBuscar = wp_pantallaInicio_BotonBuscar;
    }

    public String getwp_pantallaInicio_PrimerElementoTabla() {
        return wp_pantallaInicio_PrimerElementoTabla;
    }

    public void setwp_pantallaInicio_PrimerElementoTabla(String wp_pantallaInicio_PrimerElementoTabla) {
        this.wp_pantallaInicio_PrimerElementoTabla = wp_pantallaInicio_PrimerElementoTabla;
    }

    public String getwp_pantallaInicio_textBoxEmail() {
        return wp_pantallaInicio_textBoxEmail;
    }

    public void setwp_pantallaInicio_textBoxEmail(String wp_pantallaInicio_PrimerElementoTabla) {
        this.wp_pantallaInicio_textBoxEmail = wp_pantallaInicio_textBoxEmail;
    }

    public String getwp_pantallaInicio_primerElementoTablaBusquedaEmail() {
        return wp_pantallaInicio_primerElementoTablaBusquedaEmail;
    }

    public void setwp_pantallaInicio_primerElementoTablaBusquedaEmail(String wp_pantallaInicio_primerElementoTablaBusquedaEmail) {
        this.wp_pantallaInicio_primerElementoTablaBusquedaEmail = wp_pantallaInicio_primerElementoTablaBusquedaEmail;
    }

//    public String getwp_pantallaInicio_BotonBuscarEmail() {
//        return wp_pantallaInicio_BotonBuscarEmail;
//    }
//
//    public void setwp_pantallaInicio_BotonBuscarEmail(String wp_pantallaInicio_BotonBuscar) {
//        this.wp_pantallaInicio_BotonBuscarEmail = wp_pantallaInicio_BotonBuscar;
//    }

    public String getwp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas() {
        return wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas;
    }

    public void setwp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas(String wp_pantallaInicio_BotonBuscar) {
        this.wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas = wp_pantallaInicio_BotonBuscar;
    }

    public String getwp_pantallaInicio_informacionDestacada_carterasActivas_verTodas() {
        return wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas;
    }

    public void setwp_pantallaInicio_informacionDestacada_carterasActivas_verTodas(String wp_pantallaInicio_BotonBuscar) {
        this.wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas = wp_pantallaInicio_BotonBuscar;
    }

    public String getwp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas() {
        return wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas;
    }

    public void setwp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas(String wp_pantallaInicio_BotonBuscar) {
        this.wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas = wp_pantallaInicio_BotonBuscar;
    }

    public String getwp_pantallaInicio_HistoricoRevocacion() {
        return wp_pantallaInicio_HistoricoRevocacion;
    }

    public void setwp_pantallaInicio_HistoricoRevocacion(String wp_pantallaInicio_BotonBuscar) {
        this.wp_pantallaInicio_HistoricoRevocacion = wp_pantallaInicio_BotonBuscar;
    }

    //##Detalles cartera

    //PID Provider PATHS

    //EAA Provider PATHS

    //Portal Usuario PATHS
    public String getCit_home_avisolegal() {
        return cit_home_avisolegal;
    }

    public String getCit_home_titulopantallaenlace() {
        return cit_home_titulopantallaenlace;
    }

}
