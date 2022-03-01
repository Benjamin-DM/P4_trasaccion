package com.example.transaccion.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Transaccion")
public class TransaccionEntity {

    @Id
    private String id;
    private String name;
    private String idClients;
    private String idClients;
    private String idMounts;

}
