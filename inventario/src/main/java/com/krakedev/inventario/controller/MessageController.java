
package com.krakedev.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.inventario.entity.Message;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<Message> mensajes = new ArrayList<>();

    public MessageController() {
        mensajes.add(new Message(1, "Krakedev escuela de programación"));
        mensajes.add(new Message(2, "Spring Boot desde cero"));
    }

    @GetMapping
    public List<Message> listarMensajes() {
        return mensajes;
    }
}