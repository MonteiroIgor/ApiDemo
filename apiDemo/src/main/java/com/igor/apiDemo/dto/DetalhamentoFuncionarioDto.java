package com.igor.apiDemo.dto;

import com.igor.apiDemo.entities.Funcionario;
import com.igor.apiDemo.entities.Status;

import java.util.Date;

public class DetalhamentoFuncionarioDto {
    
    private Long id;
    private String nome;
    private String cpf;
    private Date dt_Nascimento;
    private String telefone;
    private String email;
    private Status status;
    
    public DetalhamentoFuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.dt_Nascimento = funcionario.getDt_Nascimento();
        this.telefone = funcionario.getTelefone();
        this.email = funcionario.getEmail();
        this.status = funcionario.getStatus();
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
