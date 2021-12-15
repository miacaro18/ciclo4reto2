package zorrillo.reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.service.OrderService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/all")
    public List<Order>getOrder(){
        return orderService.getAll();
    }
    
    @GetMapping("{id}")
    public Optional<Order>getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int orderId){
        return orderService.delete(orderId);
    }

    //Consultar por zonas
    @GetMapping("/zona/{zone}")
    public List<Order> getOrderZone(@PathVariable("zone") String zone){
        return orderService.getOrderZone(zone);
    }

    //Consultar por Id
    @GetMapping("/salesman/{id}")
    public List<Order> getOrderId(@PathVariable("id") Integer id){
        return orderService.getOrderId(id);
    }

    //Consultar por estado y Id
    @GetMapping("/state/{status}/{id}")
    public List <Order> getOrderStateId(@PathVariable("status") String status, @PathVariable("id") Integer id){
        return orderService.getOrderStateId(status, id);
    }

    //Consultar por fecha
    @GetMapping("/date/{date}/{id}")
    public List <Order> ordersSalesManByDate(@PathVariable("date") String date, @PathVariable("id") int id){
        return orderService.ordersSalesManByDate(date, id);
    }
}

