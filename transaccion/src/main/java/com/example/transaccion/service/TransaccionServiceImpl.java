package com.example.transaccion.service;

import com.example.transaccion.model.TransaccionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransaccionServiceImpl implements TransaccionServiceRed{


    @Override
    public Flux<TransaccionEntity> findAll() {
        return null;
    }

    @Override
    public Flux<TransaccionEntity> findTransaccionByName(String name) {
        return null;
    }

    @Override
    public Flux<TransaccionEntity> findTransaccionByIdClient(String idClients) {
        return null;
    }

    @Override
    public Mono<TransaccionEntity> save(TransaccionEntity transaccion) {
        return null;
    }

    @Override
    public Mono<TransaccionEntity> update(TransaccionEntity transaccion) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
