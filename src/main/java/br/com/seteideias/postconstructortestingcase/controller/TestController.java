package br.com.seteideias.postconstructortestingcase.controller;

import br.com.seteideias.postconstructortestingcase.service.TestService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostConstruct
    private void assimQueIniciar(){
        System.out.println(testService.processo());
    }

    @GetMapping("/teste")
    public ResponseEntity<String> request(){
        return ResponseEntity.ok(testService.processo());
    }

}
