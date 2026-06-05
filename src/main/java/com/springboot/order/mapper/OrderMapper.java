package com.springboot.order.mapper;

import com.springboot.coffee.entity.Coffee;
import com.springboot.order.dto.OrderCoffeeDto;
import com.springboot.order.dto.OrderCoffeeResponseDto;
import com.springboot.order.dto.OrderPatchDto;
import com.springboot.order.dto.OrderPostDto;
import com.springboot.order.dto.OrderResponseDto;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);

    default OrderCoffee orderCoffeeDtoToOrderCoffee(OrderCoffeeDto orderCoffeeDto) {
        OrderCoffee orderCoffee = new OrderCoffee();

        Coffee coffee = new Coffee();
        coffee.setCoffeeId(orderCoffeeDto.getCoffeeId());

        orderCoffee.setCoffee(coffee);
        orderCoffee.setQuantity(orderCoffeeDto.getQuantity());

        return orderCoffee;
    }

    default OrderCoffeeResponseDto orderCoffeeToOrderCoffeeResponseDto(OrderCoffee orderCoffee) {
        Coffee coffee = orderCoffee.getCoffee();

        return new OrderCoffeeResponseDto(
                coffee.getCoffeeId(),
                coffee.getKorName(),
                coffee.getEngName(),
                coffee.getPrice(),
                orderCoffee.getQuantity()
        );
    }
}
