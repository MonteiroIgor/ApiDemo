package com.igor.apiDemo.controller;

import com.igor.apiDemo.controller.form.ClienteForm;
import com.igor.apiDemo.dto.ClienteDto;
import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
    public void cadastrar(@RequestBody ClienteForm clienteForm){
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);
    }


}
