package com.igor.apiDemo.controller.form;

import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.repository.ClienteRepository;

import javax.validation.constraints.NotNull;

public class AtualizaClienteForm{

    @NotNull
    private String telefone;

    @NotNull
    private String email;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente atualizar(Long id, ClienteRepository clienteRepository){
        Cliente cliente = clienteRepository.getOne(id);

        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);

       return cliente;
    }
}
