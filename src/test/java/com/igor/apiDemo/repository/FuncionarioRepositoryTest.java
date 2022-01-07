package com.igor.apiDemo.repository;

import com.igor.apiDemo.entities.Cliente;
import com.igor.apiDemo.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioRepositoryTest extends JpaRepository<Funcionario, Long> {

    @Query(value = "select * from (select *\n" +
            "            from FUNCIONARIO\n" +
            "            where STATUS = 'ATIVO' \n" +
            "            ORDER BY RANDOM() LIMIT 1)\n" +
            "            where rownum = 1",nativeQuery = true)
    Cliente findByFuncionarioAtivo();

    @Query(value = "select * from (select *\n" +
            "            from FUNCIONARIO\n" +
            "            where STATUS = 'INATIVO' \n" +
            "            ORDER BY RANDOM() LIMIT 1)\n" +
            "            where rownum = 1",nativeQuery = true)
    Cliente findByFuncionarioInativo();


}
