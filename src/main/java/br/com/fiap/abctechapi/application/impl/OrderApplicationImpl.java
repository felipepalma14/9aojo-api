package br.com.fiap.abctechapi.application.impl;

import br.com.fiap.abctechapi.application.OrderApplication;
import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDto;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.model.OrderLocation;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public void createOrder(OrderDto orderDto) throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(orderDto.getOperatorId());
        newOrder.setStartOrderLocation(getOrderLocationFRomOrderLocationDTO(orderDto.getStart()));
        newOrder.setEndOrderLocation(getOrderLocationFRomOrderLocationDTO(orderDto.getEnd()));

        this.orderService.saveOrder(newOrder, orderDto.getAssists());
    }

    private OrderLocation getOrderLocationFRomOrderLocationDTO(OrderLocationDto dto){
        OrderLocation orderLocation = new OrderLocation();
        orderLocation.setLatitude(dto.getLatitude());
        orderLocation.setLongitude(dto.getLongitude());
        orderLocation.setDate(dto.getDateTime());
        return orderLocation;
    }
}
