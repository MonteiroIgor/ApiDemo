package com.igor.apiDemo.controller;

import com.igor.apiDemo.controller.form.AtualizaClienteForm;
import com.igor.apiDemo.controller.form.ClienteForm;
import com.igor.apiDemo.dto.ClienteDto;
import com.igor.apiDemo.dto.DetalhamentoClienteDto;
import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public List<ClienteDto> lista(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.converter(clientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder){
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoClienteDto> consultaDetalhadaCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(new DetalhamentoClienteDto(cliente.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaClienteForm clienteForm){

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteForm.atualizar(id, clienteRepository);
            return ResponseEntity.ok(new ClienteDto(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
