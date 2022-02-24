package com.demobackend.routes;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demobackend.database.model.*;
import com.demobackend.database.repository.UserRepo;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Users {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcrypt;

    @GetMapping()
    public List<User> getUsersList(){
        return userRepo.findAll();
    }

    @ResponseBody @PutMapping("/authenticate")
    public ResUser getUserAuth(HttpServletRequest request){
        String authorizationHeader = request.getHeader("access_token");
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        User user = userRepo.findWithUsername(username);
        if (user!=null){
            return new ResUser(user,true);
        }else{
            return new ResUser(null,false);
        }
    }

    @ResponseBody @PostMapping("/logout")
    public ResUser userLogout(){
        return new ResUser(null,false);
    }

    @ResponseBody @PostMapping("/signup")
    public Object userSignUp(@RequestBody User req){
        User findUser = userRepo.findWithUsername(req.getUsername());
        if(findUser!=null){
            return new ResMessage("Email or Username already existed");
        }else{
            req.setPassword(bcrypt.encode(req.getPassword()));
            userRepo.save(req);
            return new ResUser(req,true);
        }
    }

    @ResponseBody @PostMapping("/update/{id}")
    public ResMessage updateUser(@PathVariable String id,@RequestBody User req){
        req.setId(id);
        User result = userRepo.save(req);
        if (result!=null) {
            return new ResMessage("Your profile has been updated");
        } else{
            return new ResMessage("Failed to updated your profile");
        }
    }

    @ResponseBody @PostMapping("/upload/{id}")
    public ResMessage uploadImg(@PathVariable String id,@RequestBody User req){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("img",req.getImg());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        if(result.wasAcknowledged()){
            return new ResMessage("Your avatar has been updated");
        } else {
            return new ResMessage("Failed to upload your avatar");
        }
    }

    //CART

    @ResponseBody @PostMapping("/addcart/{id}")
    public ResMessage updateCart(@PathVariable String id,@RequestBody PurchaseProduct req){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.push("cart",req);
        update.inc("cart_total",req.getPrice() * req.getQuantity());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        if (result.wasAcknowledged()){
            return new ResMessage("Your cart has been updated");
        }else{
            return new ResMessage("Failed to update your cart");
        }
    }

    @ResponseBody @PostMapping("/removecart/{id}")
    public ResMessage removeCart(@PathVariable String id, @RequestBody UpdateCart req){
        User findUser = userRepo.findWithUserId(id);
        List<PurchaseProduct> cart = findUser.getCart();
        cart.removeIf(item -> item.get_id().equals(req.get_id()) && item.getColor().equals(req.getColor()));
        findUser.setCart_total(findUser.getCart_total() - req.getPrices());
        findUser.setCart(cart);
        User result=userRepo.save(findUser);
        if (result!=null){
            return new ResMessage("Your cart has been updated");
        }else{
            return new ResMessage("Failed to update your cart");
        }
    }

    @ResponseBody @PostMapping("/clearcart/{id}")
    public ResMessage clearCart(@PathVariable String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        List<PurchaseProduct> newCart = new ArrayList<>();
        update.set("cart_total",0);
        update.set("cart", newCart);
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        if (result.wasAcknowledged()){
            return new ResMessage("Your cart has been clear");
        }else{
            return new ResMessage("Failed to clear your cart");
        }
    }

    @ResponseBody @PostMapping("/updatequantity/{id}")
    public ResMessage updateQuantity(@PathVariable String id,@RequestBody PurchaseProduct req ){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id).and("cart._id").is(req.get_id()).and("cart.color").is(req.getColor()));
        Update update = new Update();
        update.inc("cart.quantity",req.getQuantity());
        update.inc("cart_total",req.getPrice());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        if (result.wasAcknowledged()){
            return new ResMessage("Your cart has been updated");
        }else{
            return new ResMessage("Failed update your cart");
        }
    }
}
