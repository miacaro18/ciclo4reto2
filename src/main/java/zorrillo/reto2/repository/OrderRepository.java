package zorrillo.reto2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import zorrillo.reto2.model.Order;
import zorrillo.reto2.repository.crud.OrderCrudRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    //Consultar por zonas
    public List<Order> getOrderZone(String zone){
        return orderCrudRepository.getOrderByZone(zone);
    }

    //Consultar por Id
    public List<Order> getOrderId(Integer id){
        return orderCrudRepository.getOrderById(id);
    }

    //Consultar por estado y Id
    public List<Order> getOrderStateId(String status ,Integer id){
        return orderCrudRepository.getOrderByStateId(status, id);
    }

    //Consultar por fecha y Id
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }  

}
