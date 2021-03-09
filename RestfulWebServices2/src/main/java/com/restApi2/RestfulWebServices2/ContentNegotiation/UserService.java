package com.restApi2.RestfulWebServices2.ContentNegotiation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
@Primary
public class UserService {
    private static ArrayList<User> users = new ArrayList<>();

    private static int userCount = 2;

    static {
        users.add(new User(1,"Parth"));
        users.add(new User(2,"Megha"));
    }

    public ArrayList<User> findAll(){
        return users;
    }

    public User findOneById(Integer id){
        for (User user:users) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public User createUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        else
            return null;
        users.add(user);
        return user;
    }

    public User deleteUserById(Integer id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
