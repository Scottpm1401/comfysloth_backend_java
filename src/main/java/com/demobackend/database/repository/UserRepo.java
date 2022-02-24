package com.demobackend.database.repository;

import com.demobackend.database.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {

    @Query("{id:'?0'}")
    User findWithUserId(String id);

    @Query("{username:'?0'}")
    User findWithUsername(String username);

}
