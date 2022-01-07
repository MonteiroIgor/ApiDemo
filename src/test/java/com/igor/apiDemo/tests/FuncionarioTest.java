package com.igor.apiDemo.tests;

import com.igor.apiDemo.config.GenericsTest;
import com.igor.apiDemo.repository.FuncionarioRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

public class FuncionarioTest extends GenericsTest {

    @Autowired
    private FuncionarioRepositoryTest funcionarioRepositoryTest;
}
