package com.igor.apiDemo.controller.form;

import com.igor.apiDemo.entities.Funcionario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class FuncionarioForm {

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty
    private String cpf;

    @NotNull @NotEmpty
    private String telefone;

    @NotNull @NotEmpty
    private String email;

    @NotNull
    private Date dt_Nascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    public Date getDt_Nascimento() {
        return dt_Nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_Nascimento = dt_nascimento;
    }

    public Funcionario converter() {

        return new Funcionario(nome, cpf, email, telefone, dt_Nascimento);
    }
}
