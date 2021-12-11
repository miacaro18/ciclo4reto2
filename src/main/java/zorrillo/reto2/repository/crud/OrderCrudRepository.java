package zorrillo.reto2.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import zorrillo.reto2.model.Order;

public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    //Consultar por zonas
    //{"salesMan.zone":{$eq:"?0"}}
    @Query("{'salesMan.zone':{$eq:'?0'}}")
    public List<Order> getOrderZone(String zone);
    
}
