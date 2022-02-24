package com.demobackend.routes;

import com.demobackend.database.model.Product;
import com.demobackend.database.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class Products {

    //Inject Product Repo
    @Autowired
    ProductRepo product;

    @GetMapping()
    public List<Product> getProductsList(){
        return product.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return product.findWithProductId(id);
    }

    @PostMapping()
    public Product postProduct(@RequestBody Product newProduct){
        return product.save(newProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        product.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable String id,@RequestBody Product newProduct){
        newProduct.setId(id);
        return product.save(newProduct);
    }
}
