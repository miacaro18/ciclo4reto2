package zorrillo.reto2.controller;

import java.util.List;
import java.util.Optional;

import zorrillo.reto2.model.Fragance;
import zorrillo.reto2.service.FraganceServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fragance")
public class FraganceControlador {
    @Autowired
    private FraganceServicio fraganceServicio;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance save(@RequestBody Fragance fragance){
        return fraganceServicio.save(fragance);
    }
    
    @GetMapping("/all")
    public List<Fragance>getFragance(){
        return fraganceServicio.getAll();
    }

    @GetMapping("{id}")
    public Optional<Fragance>getFragance(@PathVariable("id") String id){
        return fraganceServicio.getFragance(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteFragance(@PathVariable("id") String id){
        return fraganceServicio.deleteFragance(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance){
        return fraganceServicio.update(fragance);
    }
}
