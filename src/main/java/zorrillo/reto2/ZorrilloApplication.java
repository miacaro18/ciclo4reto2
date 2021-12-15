package zorrillo.reto2;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zorrillo.reto2.repository.crud.OrderCrudRepository;
import zorrillo.reto2.repository.crud.UserCrudRepository;
//import zorrillo.reto2.repository.crud.FraganceCrudRepositorio;


@SpringBootApplication
public class ZorrilloApplication implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;
	//private FraganceCrudRepositorio fraganceCrudRepositorio;
	
	@Autowired
	private OrderCrudRepository orderCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(ZorrilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		userCrudRepository.deleteAll();  //Borra la base de datos al inicio de la aplicacion
		orderCrudRepository.deleteAll();
		//fraganceCrudRepositorio.deleteAll();
	}
}
