package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.OrderApplication;
import br.com.fiap.abctechapi.application.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderApplication orderApplication;


    public OrderController(@Autowired OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDto dto) throws Exception {
        orderApplication.createOrder(dto);
        return ResponseEntity.ok().build();
    }
}
