package com.igor.apiDemo.repository;

import com.igor.apiDemo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepositoryTest extends JpaRepository<Cliente, Long> {

    @Query(value = "select * from (select *\n" +
            "            from CLIENTE\n" +
            "            where STATUS = 'ATIVO' \n" +
            "            ORDER BY RANDOM() LIMIT 1)\n" +
            "            where rownum = 1",nativeQuery = true)
    Cliente findByClienteAtivo();

    @Query(value = "select * from (select *\n" +
            "            from CLIENTE\n" +
            "            where STATUS = 'INATIVO' \n" +
            "            ORDER BY RANDOM() LIMIT 1)\n" +
            "            where rownum = 1",nativeQuery = true)
    Cliente findByClienteInativo();


}
