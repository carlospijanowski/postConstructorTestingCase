package br.com.seteideias.postconstructortestingcase.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String processo(){

        try {
            Thread.sleep(3000);
            return "Hello World";
        } catch (InterruptedException e) {
            return "failed";
        }

    }

}
