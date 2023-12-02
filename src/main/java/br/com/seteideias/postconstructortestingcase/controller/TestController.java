package br.com.seteideias.postconstructortestingcase.controller;

import br.com.seteideias.postconstructortestingcase.service.TestService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostConstruct
    private void assimQueIniciar(){
        System.out.println(testService.processo());
    }

    @GetMapping("/teste")
    public ResponseEntity<String> request(@RequestHeader(required = false) HttpHeaders httpHeaders){

        Map<String, String> singleValueMap = httpHeaders.toSingleValueMap();

        Set<Map.Entry<String, String>> entries = singleValueMap.entrySet();

        boolean clienteId = entries.stream().anyMatch(e -> e.getValue().equals("clienteId") && e.getKey().equals("2103"));


        System.out.println(httpHeaders);
        return ResponseEntity.ok(testService.processo());
    }

}
