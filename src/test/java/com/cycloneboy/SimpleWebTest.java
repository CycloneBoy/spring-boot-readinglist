package com.cycloneboy;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by CycloneBoy on 2017/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SimpleWebTest {

    @Test(expected = HttpClientErrorException.class)
    public void pageNotFound(){
        RestTemplate rest = new RestTemplate();
        rest.getForObject("http:..localhost:8080/cycloneboy",String.class);
       //ail("should result in Http 404");

    }
}
