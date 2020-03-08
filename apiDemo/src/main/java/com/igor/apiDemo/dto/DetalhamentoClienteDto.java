package com.igor.apiDemo.dto;

import ch.qos.logback.core.net.server.Client;
import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.entities.Status;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhamentoClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private Date dt_Nascimento;
    private String telefone;
    private String email;
    private Status status;

    public DetalhamentoClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dt_Nascimento = cliente.getDt_Nascimento();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.status = cliente.getStatus();
    }

    public static List<DetalhamentoClienteDto> converte(List<Cliente> clientes){

        return clientes.stream().map(DetalhamentoClienteDto::new).collect(Collectors.toList());
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDt_Nascimento() {
        return dt_Nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }
}
