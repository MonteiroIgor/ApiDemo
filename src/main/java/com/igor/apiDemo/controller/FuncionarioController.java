package com.igor.apiDemo.controller;

import com.igor.apiDemo.controller.form.AtualizaFuncionarioForm;
import com.igor.apiDemo.controller.form.FuncionarioForm;
import com.igor.apiDemo.dto.DetalhamentoFuncionarioDto;
import com.igor.apiDemo.dto.FuncionarioDto;
import com.igor.apiDemo.entities.Funcionario;
import com.igor.apiDemo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<FuncionarioDto> lista(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return FuncionarioDto.converter(funcionarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid FuncionarioForm funcionarioForm, UriComponentsBuilder uriBuilder){
        Funcionario funcionario = funcionarioForm.converter();
        funcionarioRepository.save(funcionario);

        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoFuncionarioDto> consultaDetalhadaFuncionario(@PathVariable Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            return ResponseEntity.ok(new DetalhamentoFuncionarioDto(funcionario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaFuncionarioForm funcionarioForm){

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if(funcionarioOptional.isPresent()){
            Funcionario funcionario = funcionarioForm.atualizar(id, funcionarioRepository);
            return ResponseEntity.ok(new FuncionarioDto(funcionario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
