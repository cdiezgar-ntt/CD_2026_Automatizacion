package com.nttdata.automation.utils;

public class Properties {

    //######WALLET PROVIDER PATHS
    //##Control Panel
    public String pantallaLogin_BotonAcceder;
    public String pantallaInicio_BotonBuscar;
    public String pantallaInicio_PrimerElementoTabla;
    public String pantallaInicio_textBoxEmail;
    public String pantallaInicio_BotonBuscarEmail;
    public String pantallaInicio_primerElementoTablaBusquedaEmail;
    public String pantallInicio_informacionDestacada_carterasActivadas_verTodas;
    public String pantallInicio_informacionDestacada_carterasActivas_verTodas;
    public String pantallInicio_informacionDestacada_carterasRevocadas_verTodas;
    public String pantallaInicio_HistoricoRevocacion;
    //##Detalles cartera

    //PID Provider PATHS

    //EAA Provider PATHS

    //Portal Usuario PATHS


    public static PropertiesManager pm = new PropertiesManager();

    public void read(){

        //######WALLET PROVIDER PATHS
        //##Control Panel
        System.out.println("Leyendo valores de properties para pantalla principal...");
        pantallaLogin_BotonAcceder = pm.readPropertiesPantallaIncio("pantallaLogin_BotonAcceder");
        System.out.println("Valor leído para pantallaLogin_Acceder: " + pantallaLogin_BotonAcceder);
        pantallaInicio_BotonBuscar = pm.readPropertiesPantallaIncio("pantallaInicio_BotonBuscar");
        System.out.println("Valor leído para pantallaInicio_BotonBuscar: " + pantallaInicio_BotonBuscar);
        pantallaInicio_PrimerElementoTabla = pm.readPropertiesPantallaIncio("pantallaInicio_PrimerElementoTabla");
        System.out.println("Valor leído para pantallaInicio_PrimerElementoTabla: " + pantallaInicio_PrimerElementoTabla);
        pantallaInicio_textBoxEmail = pm.readPropertiesPantallaIncio("pantallaInicio_textBoxEmail");
        System.out.println("Valor leído para pantallaInicio_textBoxEmail: " + pantallaInicio_textBoxEmail);
        pantallaInicio_primerElementoTablaBusquedaEmail = pm.readPropertiesPantallaIncio("pantallaInicio_primerElementoTablaBusquedaEmail");
        System.out.println("Valor leído para pantallaInicio_primerElementoTablaBusquedaEmail: " + pantallaInicio_primerElementoTablaBusquedaEmail);
        pantallaInicio_BotonBuscarEmail = pm.readPropertiesPantallaIncio("pantallaInicio_BotonBuscarEmail");
        System.out.println("Valor leído para pantallaInicio_BotonBuscarEmail: " + pantallaInicio_BotonBuscarEmail);
        pantallInicio_informacionDestacada_carterasActivadas_verTodas = pm.readPropertiesPantallaIncio("pantallInicio_informacionDestacada_carterasActivadas_verTodas");
        System.out.println("Valor leído para pantallInicio_informacionDestacada_carterasActivadas_verTodas: " + pantallInicio_informacionDestacada_carterasActivadas_verTodas);
        pantallInicio_informacionDestacada_carterasActivas_verTodas = pm.readPropertiesPantallaIncio("pantallInicio_informacionDestacada_carterasActivas_verTodas");
        System.out.println("Valor leído para pantallInicio_informacionDestacada_carterasActivas_verTodas: " + pantallInicio_informacionDestacada_carterasActivas_verTodas);
        pantallInicio_informacionDestacada_carterasRevocadas_verTodas = pm.readPropertiesPantallaIncio("pantallInicio_informacionDestacada_carterasRevocadas_verTodas");
        System.out.println("Valor leído para pantallInicio_informacionDestacada_carterasRevocadas_verTodas: " + pantallInicio_informacionDestacada_carterasRevocadas_verTodas);
        pantallaInicio_HistoricoRevocacion = pm.readPropertiesPantallaIncio("pantallaInicio_HistoricoRevocacion");
        System.out.println("Valor leído para pantallaInicio_HistoricoRevocacion: " + pantallaInicio_HistoricoRevocacion);
        //##Detalles cartera

        //PID Provider PATHS

        //EAA Provider PATHS

        //Portal Usuario PATHS

    }

    //######WALLET PROVIDER Getter y Setter
    //##Control Panel
    public String getPantallaLogin_BotonAcceder() {
        return pantallaLogin_BotonAcceder;
    }

    public void setPantallaLogin_BotonAcceder(String pantallaLogin_BotonAcceder) {
        this.pantallaLogin_BotonAcceder = pantallaLogin_BotonAcceder;
    }

    public String getPantallaInicio_BotonBuscar() {
        return pantallaInicio_BotonBuscar;
    }

    public void setPantallaInicio_BotonBuscar(String pantallaInicio_BotonBuscar) {
        this.pantallaInicio_BotonBuscar = pantallaInicio_BotonBuscar;
    }

    public String getPantallaInicio_PrimerElementoTabla() {
        return pantallaInicio_PrimerElementoTabla;
    }

    public void setPantallaInicio_PrimerElementoTabla(String pantallaInicio_PrimerElementoTabla) {
        this.pantallaInicio_PrimerElementoTabla = pantallaInicio_PrimerElementoTabla;
    }

    public String getPantallaInicio_textBoxEmail() {
        return pantallaInicio_textBoxEmail;
    }

    public void setPantallaInicio_textBoxEmail(String pantallaInicio_PrimerElementoTabla) {
        this.pantallaInicio_textBoxEmail = pantallaInicio_textBoxEmail;
    }

    public String getPantallaInicio_primerElementoTablaBusquedaEmail() {
        return pantallaInicio_primerElementoTablaBusquedaEmail;
    }

    public void setPantallaInicio_primerElementoTablaBusquedaEmail(String pantallaInicio_primerElementoTablaBusquedaEmail) {
        this.pantallaInicio_primerElementoTablaBusquedaEmail = pantallaInicio_primerElementoTablaBusquedaEmail;
    }

    public String getPantallaInicio_BotonBuscarEmail() {
        return pantallaInicio_BotonBuscarEmail;
    }

    public void setPantallaInicio_BotonBuscarEmail(String pantallaInicio_BotonBuscar) {
        this.pantallaInicio_BotonBuscarEmail = pantallaInicio_BotonBuscar;
    }

    public String getpantallInicio_informacionDestacada_carterasActivadas_verTodas() {
        return pantallInicio_informacionDestacada_carterasActivadas_verTodas;
    }

    public void setpantallInicio_informacionDestacada_carterasActivadas_verTodas(String pantallaInicio_BotonBuscar) {
        this.pantallInicio_informacionDestacada_carterasActivadas_verTodas = pantallaInicio_BotonBuscar;
    }

    public String getpantallInicio_informacionDestacada_carterasActivas_verTodas() {
        return pantallInicio_informacionDestacada_carterasActivas_verTodas;
    }

    public void setpantallInicio_informacionDestacada_carterasActivas_verTodas(String pantallaInicio_BotonBuscar) {
        this.pantallInicio_informacionDestacada_carterasActivas_verTodas = pantallaInicio_BotonBuscar;
    }

    public String getpantallInicio_informacionDestacada_carterasRevocadas_verTodas() {
        return pantallInicio_informacionDestacada_carterasRevocadas_verTodas;
    }

    public void setpantallInicio_informacionDestacada_carterasRevocadas_verTodas(String pantallaInicio_BotonBuscar) {
        this.pantallInicio_informacionDestacada_carterasRevocadas_verTodas = pantallaInicio_BotonBuscar;
    }

    public String getpantallaInicio_HistoricoRevocacion() {
        return pantallaInicio_HistoricoRevocacion;
    }

    public void setpantallaInicio_HistoricoRevocacion(String pantallaInicio_BotonBuscar) {
        this.pantallaInicio_HistoricoRevocacion = pantallaInicio_BotonBuscar;
    }

    //##Detalles cartera

    //PID Provider PATHS

    //EAA Provider PATHS

    //Portal Usuario PATHS


}
