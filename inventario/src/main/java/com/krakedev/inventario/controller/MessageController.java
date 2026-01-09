
package com.krakedev.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public Message obtenerMensajePorId(@PathVariable int id) {
        Optional <Message> mensaje = mensajes.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        return mensaje.orElse(null);
    }

    @PostMapping
    public Message crearMensaje(@RequestBody Message mensaje) {
        mensajes.add(mensaje);
        return mensaje;

    }
}
