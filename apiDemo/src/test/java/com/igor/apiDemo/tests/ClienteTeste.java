package com.igor.apiDemo.tests;

import com.igor.apiDemo.config.GenericsTest;
import com.igor.apiDemo.controller.form.AtualizaClienteForm;
import com.igor.apiDemo.controller.form.ClienteForm;
import com.igor.apiDemo.dtos.ClienteTestsDto;
import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.repository.ClienteRepositoryTest;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class ClienteTeste extends GenericsTest {

    @Autowired
    private ClienteRepositoryTest clienteRepositoryTest;

    @Test
    public void deveListarTodosClientes(){

        //DADO
        given()

        //QUANDO
        .when()
                .get("/clientes")
        //ENTÃO
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema/ListaClientesSCHEMA.json"));
    }

    @Test
    public void deveConsultarClienteAtivoPorID(){

        Cliente cliente = clienteRepositoryTest.findByClienteAtivo();

        given()

        .when()
                .get("/clientes/{id}", cliente.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema/ConsultaClienteIDSCHEMA.json")).extract().
                        response().path("id", String.valueOf(equalTo(cliente.getId())));

    }


    @Test
    public void deveConsultarClienteInativoPorID(){

        Cliente cliente = clienteRepositoryTest.findByClienteInativo();

        given()

        .when()
                .get("/clientes/{id}", cliente.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema/ConsultaClienteIDSCHEMA.json")).extract().
                response().path("id", String.valueOf(equalTo(cliente.getId())),
                String.valueOf(containsString(cliente.getNome())));
    }

    @Test
    public void deveCadastrarCliente(){

        ClienteForm clienteForm = ClienteTestsDto.cadastroCliente();

        Integer idCliente = given()
            .contentType(ContentType.JSON)
            .body(clienteForm)
        .when()
               .post("/clientes")
        .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema/CadastroClienteSCHEMA.json")).extract().
                        response().
                        path("id");


        Cliente cliente = clienteRepositoryTest.getOne(Long.valueOf(idCliente));
        Assert.assertEquals(Long.valueOf(idCliente),cliente.getId());
    }

    @Test
    public void deveAtualizarContatosCliente(){

        Cliente cliente = clienteRepositoryTest.findByClienteAtivo();

        AtualizaClienteForm atualizaClienteForm = ClienteTestsDto.atualizaCliente();

        given()
                .contentType(ContentType.JSON)
                .body(atualizaClienteForm)
        .when()
                .put("/clientes/{id}", cliente.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all()
                .body(matchesJsonSchemaInClasspath("schema/AtualizaClienteSCHEMA.json")).extract()
                    .response().path("id", String.valueOf(equalTo(cliente.getId())));

    }

    @Test
    public void deveRemoverCliente(){

        Cliente cliente = clienteRepositoryTest.findByClienteAtivo();

        given()

        .when()
                .delete("/clientes/{id}",cliente.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all();

    }


}
