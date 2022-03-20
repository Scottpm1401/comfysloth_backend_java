package com.demobackend.routes;

import com.demobackend.database.model.PaymentResponse;
import com.demobackend.database.model.PurchaseForm;
import com.demobackend.database.model.ResMessage;
import com.demobackend.database.model.User;
import com.mongodb.client.result.UpdateResult;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class Payment {

    @Autowired
    MongoTemplate mongoTemplate;

    @Value("${stripe.api.key}")
    private String stripeSK;

    @PostConstruct
    public void init(){
        Stripe.apiKey=stripeSK;
    }

    @ResponseBody @PostMapping()
    public Object StripePayment(@RequestBody com.demobackend.database.model.Payment createPayment) throws StripeException{
       try{
               PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                   .setAmount(createPayment.getAmount())
                   .setCurrency("usd")
                   .setDescription("comfysloth company")
                   .setPaymentMethod(createPayment.getId())
                   .setConfirm(true).build();
           PaymentIntent intent = PaymentIntent.create(createParams);
           Date today = new Date();
           String date = String.valueOf(today.getMonth() + 1) + " " + String.valueOf(today.getDate()) + " " + String.valueOf(today.getYear());
           PurchaseForm purchaseForm = new PurchaseForm(
                   intent.getId(),
                   intent.getStatus(),
                   createPayment.getBilling_details(),
                   createPayment.getCart(),
                   createPayment.getTotal(),
                   date,
                   intent.getPaymentMethod()
           );
           Query query = new Query();
           query.addCriteria(Criteria.where("id").is(createPayment.getUser_id()));
           Update update = new Update();
           update.push("purchase",purchaseForm);
           UpdateResult result = mongoTemplate.updateFirst(query,update, User.class);
           if (result.wasAcknowledged()){
               return new PaymentResponse("Payment successful",true,intent.getStatus(),purchaseForm,1);
           }else{
               return new ResMessage("Failed to update your cart");
           }
       }catch (Exception exception){
           throw exception;
       }
    }

}
