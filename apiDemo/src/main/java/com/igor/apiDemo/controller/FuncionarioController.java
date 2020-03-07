package com.igor.apiDemo.controller;

import com.igor.apiDemo.dto.FuncionarioDto;
import com.igor.apiDemo.entities.Funcionario;
import com.igor.apiDemo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @RequestMapping("/funcionarios")
    public List<FuncionarioDto> lista(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return FuncionarioDto.converter(funcionarios);
    }
}
