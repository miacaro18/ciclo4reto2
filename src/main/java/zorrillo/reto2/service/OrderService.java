package zorrillo.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id); 
    }

    public boolean delete(int orderId){
        Optional<Order> orden = orderRepository.getOrder(orderId);
        if (orden.isEmpty()) {
            return false;
        } else {
            orderRepository.delete(orden.get());
            return true;
        }
    }

    public Order save(Order order){
        if (order.getId()==null) {
            return order;
        }else{
            return orderRepository.save(order);
        }
    }
    public Order update(Order order){
        if (order.getId()!=null) {
            Optional<Order> consulta = orderRepository.getOrder(order.getId());
            if (!consulta.isEmpty()) {
                if (order.getRegisterDay() != null) {
                    consulta.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null){
                    consulta.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    consulta.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts() != null) {
                    consulta.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    consulta.get().setProducts(order.getProducts());
                }
                return orderRepository.save(consulta.get());
            }
        }
        return order;
    }

    public List<Order> getOrderZone (String zone){
        return orderRepository.getOrderZone(zone);
    }
}
