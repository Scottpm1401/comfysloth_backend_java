package com.demobackend.database.repository;

import com.demobackend.database.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
    @Query("{id:'?0'}")
    Product findWithProductId(String id);

}
