package com.example.transaccion.controller;


import com.example.transaccion.model.Mensaje;
import com.example.transaccion.model.TransaccionEntity;
import com.example.transaccion.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/transaccion")
public class ControllerTransaccion {

    private final TransaccionService service;

    @GetMapping("/get")
    public Flux<TransaccionEntity> getTransaccion(){
        log.info("Iniciando lista");
        return service.findAll();
    }

    @GetMapping("/getIdClient/{idClient}")
    public Flux<TransaccionEntity> getTransaccionByIdClient(@PathVariable("idClient") String idClient){
        return service.findTransaccionByIdClient(idClient);
    }

    @PostMapping("/post")
    Mono<TransaccionEntity> postClient(@RequestBody TransaccionEntity transaccion){

        return service.save(transaccion);
    }

    @PostMapping("/update")
    Mono<TransaccionEntity> update (@RequestBody TransaccionEntity transaccion ){
        return service.update(transaccion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable("id") String id) {
        service.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
