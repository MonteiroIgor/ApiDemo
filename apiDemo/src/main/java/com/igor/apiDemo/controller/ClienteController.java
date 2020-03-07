package com.igor.apiDemo.controller;

import com.igor.apiDemo.dto.ClienteDto;
import com.igor.apiDemo.entities.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @RequestMapping("/clientes")
    public List<ClienteDto> lista(){
        Cliente cliente = new Cliente("igor monteiro","08675504497", "1991/02/12", "995566887", "ele@gmail.com");
        
        return ClienteDto.converter(Arrays.asList(cliente));
    }


}
