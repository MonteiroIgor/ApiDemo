package com.igor.apiDemo.controller.form;

import com.igor.apiDemo.entities.Funcionario;
import com.igor.apiDemo.repository.FuncionarioRepository;

import javax.validation.constraints.NotNull;

public class AtualizaFuncionarioForm {

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

    public Funcionario atualizar(Long id, FuncionarioRepository funcionarioRepository){
        Funcionario funcionario = funcionarioRepository.getOne(id);

        funcionario.setTelefone(this.telefone);
        funcionario.setEmail(this.email);

       return funcionario;
    }
}
