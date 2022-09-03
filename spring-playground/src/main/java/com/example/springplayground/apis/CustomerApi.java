package com.example.springplayground.apis;

import com.example.springplayground.entities.Customer;
import com.example.springplayground.service.CustomerService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerApi {
    private final Logger logger;
    private final CustomerService service;

    public CustomerApi(CustomerService service) {
        this.service = service;
        this.logger = LoggerFactory.getLogger("this.getClass()");
    }

//    @GetMapping
//    public String greet(){
//        logger.info("String to be printed");
//        return "Hello";
//    }
    @GetMapping
    public ResponseEntity<List<Customer>> get(){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> get(@PathVariable int id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer){
        service.create(customer);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Customer customer){
        service.update(id,customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
