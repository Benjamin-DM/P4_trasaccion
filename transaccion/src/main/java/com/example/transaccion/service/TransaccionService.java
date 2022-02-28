package com.example.transaccion.service;

import com.example.transaccion.model.TransaccionEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {

    Flux<TransaccionEntity> findAll();

    Flux<TransaccionEntity> findTransaccionByName(String name);

    Flux<TransaccionEntity> findTransaccionByIdClient(String idClients);

    Mono<TransaccionEntity> save(TransaccionEntity transaccion);

    Mono<TransaccionEntity> update(TransaccionEntity transaccion);

    void delete(String id);
}
