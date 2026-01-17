package org.example;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private  final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> list(){return repository.findAll();}

    @PostMapping("/{name}")
    public Product create(@PathVariable String name){return repository.save(new Product((name)));}
}
