package com.igor.apiDemo.entities;


import com.igor.apiDemo.common.MensagensDeErro;

import javax.persistence.*;

@Entity
public class Cliente {

    public Cliente(String nome, String cpf, String dt_Nascimento, String telefone, String email) {

        if(nome == null){
            throw new NullPointerException(MensagensDeErro.ERRO00001);
        }
        this.nome = nome;
        this.cpf = cpf;
        this.dt_Nascimento = dt_Nascimento;
        this.telefone = telefone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String dt_Nascimento;
    private String telefone;
    private String email;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDt_Nascimento() {
        return dt_Nascimento;
    }

    public void setDt_Nascimento(String dt_Nascimento) {
        this.dt_Nascimento = dt_Nascimento;
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
}
