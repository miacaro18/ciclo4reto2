package zorrillo.reto2.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import zorrillo.reto2.model.Order;

public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    //Consultar por zonas
    //{"salesMan.zone":{$eq:"?0"}}
    @Query("{'salesMan.zone':{$eq:'?0'}}")
    public List<Order> getOrderByZone(String zone);

    //Consultar por Id
    //{"salesMan._id":{$eq:6}}
    @Query("{'salesMan._id':{$eq:?0}}")
    public List<Order> getOrderById(Integer id);
    
    //Consultar por estado y Id
    //{status:{$eq:"Aprobada"}, "salesMan._id":{$eq:6}}
    @Query("{status:{$eq:'?0'}, 'salesMan._id':{$eq:?1}}")
    public List<Order> getOrderByStateId(String status ,Integer id);
}
