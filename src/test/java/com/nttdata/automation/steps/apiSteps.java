package com.nttdata.automation.steps;

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
import java.util.Map;

public class apiSteps {

    private static final String BASE_URL = "https://pokeapi.co/api/v2";

    private RequestSpecification request;
    private Response response;
    private JsonPath jsonPath;

    public apiSteps() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
    }

    @Given("que configuro los siguientes headers:")
    public void configuroLosSiguientesHeaders(DataTable table) {
        Map<String, String> headers = table.asMap(String.class, String.class);
        request.headers(headers);
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
