package zorrillo.reto2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.repository.crud.OrderCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public Order save (Order order){
        return orderCrudRepository.save(order);
    }

    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    public void delete(Order order){
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderZone(String zone){
        return orderCrudRepository.getOrderZone(zone);
    }
}
