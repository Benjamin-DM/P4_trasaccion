package com.example.transaccion.service;

import com.example.transaccion.model.TransaccionEntity;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheEvict;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCachePut;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheable;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCaching;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionServiceRed extends TransaccionService {

    @ReactiveRedisCacheEvict(cacheName = "CACHE_NAME", allEntries = true)
    Mono<TransaccionEntity> save(TransaccionEntity transaccion);

    @ReactiveRedisCacheable(cacheName = "CACHE_NAME", key = "all")
    Flux<TransaccionEntity> findAll () ;

    @ReactiveRedisCacheable(cacheName = "CACHE_NAME", key = "'find_' + #name")
    Flux<TransaccionEntity> findTransaccionByName (String name);

    @ReactiveRedisCacheable(cacheName = "CACHE_NAME", key = "'find_' + #idClient")
    Flux<TransaccionEntity> findTransaccionByIdClient (String idClients);

    @ReactiveRedisCaching(
            evict = {@ReactiveRedisCacheEvict(cacheName = "CACHE_NAME", key = "all")},
            put = {
                    @ReactiveRedisCachePut( cacheName = "CACHE_NAME", key = "'find_' + #CACHE_NAME.name"),
                    @ReactiveRedisCachePut( cacheName = "CACHE_NAME", key = "'find_' + #CACHE_NAME.idClients"),
                    @ReactiveRedisCachePut( cacheName = "CACHE_NAME", key = "'find_' + #CACHE_NAME.idMounts")}
    )
    Mono<TransaccionEntity> update (TransaccionEntity transaccion);
}
