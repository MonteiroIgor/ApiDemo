package com.igor.apiDemo.controller.form;

import com.igor.apiDemo.entities.Cliente;

import java.util.Date;

public class ClienteForm {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
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

    public void setDt_Nascimento(Date dt_Nascimento) {
        this.dt_Nascimento = dt_Nascimento;
    }

    public Cliente converter() {

        return new Cliente(nome, cpf, dt_Nascimento, telefone, email);
    }
}
