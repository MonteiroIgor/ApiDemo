package com.igor.apiDemo.dto;

import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.entities.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDto {

    private String nome;
    private String telefone;
    private String email;
    private Long id;
    private String status;

    public FuncionarioDto(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.telefone = funcionario.getTelefone();
        this.email = funcionario.getEmail();
        this.id = funcionario.getId();
        this.status = String.valueOf(funcionario.getStatus());
    }

    // TODO: Conversao da Lista de funcionarios para funcionarioDTO, para não necessitar usar um for usa-se a bliblioteca stream do java 8
    public static List<FuncionarioDto> converter(List<Funcionario> funcionarios) {

        return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
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

    public String getStatus() {
        return status;
    }
}
