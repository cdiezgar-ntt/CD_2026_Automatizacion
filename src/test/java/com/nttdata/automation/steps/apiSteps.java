package com.nttdata.automation.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class apiSteps {

    //private static final String BASE_URL = "https://pokeapi.co/api/v2";
    //private static final String BASE_URL = "https://reqres.in";
    private static final String BASE_URL = "https://pre-wp-cd.redsara.es/wallet-provider-back";

    private RequestSpecification request;
    private Response response;
    private JsonPath jsonPath;

    private Map<String, String> datosGuardados = new HashMap<>();

    public apiSteps() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given().relaxedHTTPSValidation();
    }

    @Given("que configuro los siguientes headers:")
    public void configuroLosSiguientesHeaders(DataTable table) {
        Map<String, String> headers = table.asMap(String.class, String.class);
        request.headers(headers);
    }


    @Then("guardo el campo {string} con el nombre de variable {string}")
    public void guardoElCampoConElNombreDeVariable(String rutaCampo, String nombreVariable) {
        String valor = jsonPath.getString(rutaCampo);
        Assert.assertNotNull("El campo " + rutaCampo + " no devolvió ningún valor", valor);
        datosGuardados.put(nombreVariable, valor);
    }

    @Given("que configuro el header {string} con la variable guardada {string}")
    public void configuroElHeaderConLaVariableGuardada(String nombreHeader, String nombreVariable) {
        String valorVariable = datosGuardados.get(nombreVariable);
        Assert.assertNotNull("La variable " + nombreVariable + " no ha sido guardada previamente", valorVariable);
        request.header(nombreHeader, valorVariable);
    }

    @When("envío una petición {string} al endpoint {string} con el body:")
    public void envioUnaPeticionAlEndpointConElBody(String metodo, String endpoint, String bodyContenido) {
        request.body(bodyContenido);
        ejecutarPeticion(metodo, endpoint);
    }

    @When("envío una petición {string} al endpoint {string} sin body")
    public void envioUnaPeticionAlEndpointSinBody(String metodo, String endpoint) {
        ejecutarPeticion(metodo, endpoint);
    }

    @When("envío una petición {string} al endpoint {string} usando el body del archivo {string}")
    public void envioUnaPeticionAlEndpointUsandoElBodyDelArchivo(String metodo, String endpoint, String rutaArchivo) {
        try {
            // Lee todo el contenido del fichero JSON externo y lo convierte a String
            String bodyContenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            request.body(bodyContenido);
            ejecutarPeticion(metodo, endpoint);

        } catch (IOException e) {
            Assert.fail("No se pudo leer el archivo JSON en la ruta: " + rutaArchivo + ". Error: " + e.getMessage());
        }
    }

    @When("envío una petición {string} al endpoint {string} usando el archivo {string} con la clave {string}")
    public void envioUnaPeticionUsandoArchivoYClave(String metodo, String endpoint, String rutaArchivo, String claveJson) {
        try {

            ObjectMapper mapper = new ObjectMapper();


            JsonNode raizDelArchivo = mapper.readTree(new File(rutaArchivo));


            JsonNode jsonEspecifico = raizDelArchivo.get(claveJson);


            Assert.assertNotNull("La clave '" + claveJson + "' no se encontró en el archivo: " + rutaArchivo, jsonEspecifico);


            String bodyContenido = jsonEspecifico.toString();


            request.body(bodyContenido);
            ejecutarPeticion(metodo, endpoint);

        } catch (IOException e) {
            Assert.fail("Error al procesar el archivo JSON centralizado: " + rutaArchivo + ". Detalles: " + e.getMessage());
        }
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int codigoEsperado) {
        Assert.assertEquals("El código de estado HTTP no coincide", codigoEsperado, response.getStatusCode());
    }

    @Then("compruebo que el campo {string} tiene el valor {string}")
    public void comprueboQueElCampoTieneElValor(String rutaCampo, String valorEsperado) {
        String valorReal = jsonPath.getString(rutaCampo);
        Assert.assertEquals("El campo " + rutaCampo + " no coincide", valorEsperado, valorReal);
    }

    @Then("compruebo que el campo {string} tiene el valor numérico {double}")
    public void comprueboQueElCampoTieneElValorNumerico(String rutaCampo, Double valorEsperado) {
        Number valorReal = jsonPath.get(rutaCampo);
        Assert.assertNotNull("El campo " + rutaCampo + " no existe en el JSON", valorReal);
        Assert.assertEquals("El valor numérico en " + rutaCampo + " no coincide", valorEsperado, valorReal.doubleValue(), 0.001);
    }

//    @Then("compruebo que el campo {string} tiene el valor booleano {boolean}")
//    public void comprueboQueElCampoTieneElValorBooleano(String rutaCampo, Boolean valorEsperado) {
//        Boolean valorReal = jsonPath.get(rutaCampo);
//        Assert.assertNotNull("El campo " + rutaCampo + " no existe en el JSON", valorReal);
//        Assert.assertEquals("El valor booleano en " + rutaCampo + " no coincide", valorEsperado, valorReal);
//    }

    @Then("compruebo que el campo {string} contiene el valor {string}")
    public void comprueboQueElCampoContieneElValor(String rutaCampo, String valorParcial) {
        String valorReal = jsonPath.getString(rutaCampo);
        Assert.assertTrue("El campo " + rutaCampo + " no contiene: " + valorParcial, valorReal.contains(valorParcial));
    }

    private void ejecutarPeticion(String metodo, String endpoint) {
        switch (metodo.toUpperCase()) {
            case "GET": response = request.get(endpoint); break;
            case "POST": response = request.post(endpoint); break;
            case "PUT": response = request.put(endpoint); break;
            case "DELETE": response = request.delete(endpoint); break;
            case "PATCH": response = request.patch(endpoint); break;
            default: throw new IllegalArgumentException("Método HTTP no soportado: " + metodo);
        }
        this.jsonPath = response.jsonPath();
    }
}
