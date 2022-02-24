package com.demobackend.routes;

import com.demobackend.database.model.Product;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/featured")
public class Featured {

    @Autowired
    MongoTemplate mongoTemplate;

    @ResponseBody @GetMapping()
    public Object getFeatureProduct(){
        Query query = new Query();
        Aggregation agg = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.DESC,"available").
                and(Sort.Direction.DESC,"stars").and(Sort.Direction.DESC,"reviews").and(Sort.Direction.DESC,"price"),Aggregation.limit(3));
        AggregationResults<Product> result = mongoTemplate.aggregate(agg,"products",Product.class);
        return result.getMappedResults();
    }
}
