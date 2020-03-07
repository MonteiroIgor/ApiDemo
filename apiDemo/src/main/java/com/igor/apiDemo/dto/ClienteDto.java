package com.igor.apiDemo.dto;

import com.igor.apiDemo.entities.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto {

    private String nome;
    private String telefone;
    private String email;
    private Long id;

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.id = cliente.getId();
    }

    // TODO: Conversao da Lista de clientes para clientesDTO, para não necessitar usar um for usa-se a bliblioteca stream do java 8
    public static List<ClienteDto> converter(List<Cliente> clientes) {

        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
}
