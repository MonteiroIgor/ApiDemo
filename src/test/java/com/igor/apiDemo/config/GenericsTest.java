package com.igor.apiDemo.config;

import com.igor.apiDemo.ApiDemoApplication;
import io.restassured.RestAssured;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiDemoApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GenericsTest {


    public void config(){

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
}
