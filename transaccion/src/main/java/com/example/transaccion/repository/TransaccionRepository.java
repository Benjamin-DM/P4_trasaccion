package com.example.transaccion.repository;

import com.example.transaccion.model.TransaccionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface TransaccionRepository extends ReactiveMongoRepository {

    Flux<TransaccionEntity> findByName(String name);
    Flux<TransaccionEntity> findByIdClients(String idClients);
}
