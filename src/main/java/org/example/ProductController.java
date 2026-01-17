package org.example;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller that talks with the database for Product entities.
 * Exposes endpoints to view all products and to insert a product.
 * Note: the POST currently uses a path variable for the product name — it works but is non-idiomatic.
 * Consider accepting a Product JSON in the request body for a more standard REST create endpoint.
 */

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
    public Product create(@PathVariable String name){
        //System.out.println("Holding up connection for 8 seconds...");
        try {
            System.out.println(">>> Holding connection to "+ name);
            Thread.sleep(10000);
        } catch (InterruptedException e) { }
        return repository.save(new Product(name));}
}
