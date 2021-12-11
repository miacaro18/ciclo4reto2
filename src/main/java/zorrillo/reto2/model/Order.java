package zorrillo.reto2.model;

import java.util.Date;
import java.util.Map;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;
    @NonNull
    private Date registerDay;
    @NonNull
    private String status;
    @NonNull
    private User salesMan;
    @NonNull
    private Map<String, Fragance> products;
    @NonNull
    private Map<String, Integer> quantities;
}
