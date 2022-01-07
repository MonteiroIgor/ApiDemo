package com.igor.apiDemo.dtos;

import com.igor.apiDemo.controller.form.AtualizaClienteForm;
import com.igor.apiDemo.controller.form.ClienteForm;
import com.igor.apiDemo.entities.Cliente;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Service
public class ClienteTestsDto {

    public static ClienteForm cadastroCliente(){

        ClienteForm clienteForm = new ClienteForm();

            clienteForm.setNome("Igor Monteiro");
            clienteForm.setCpf("10713326447");
            clienteForm.setDt_Nascimento(Date.from(Instant.ofEpochSecond(1991/12/02)));
            clienteForm.setTelefone("988858856");
            clienteForm.setEmail("igormonteiro@gmail.com");

        return clienteForm;
    }

    public static AtualizaClienteForm atualizaCliente(){

        AtualizaClienteForm atualizaClienteForm = new AtualizaClienteForm();

        atualizaClienteForm.setEmail("atualizado@gmail.com");
        atualizaClienteForm.setTelefone("999999999");

        return atualizaClienteForm;
    }
}
