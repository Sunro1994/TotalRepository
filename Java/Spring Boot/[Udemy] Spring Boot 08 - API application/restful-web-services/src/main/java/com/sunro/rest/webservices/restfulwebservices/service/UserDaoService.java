package com.sunro.rest.webservices.restfulwebservices.service;

import com.sunro.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    //JPA/Hibernate > Database
    // userDaoService > static LIsts
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;
    static{
        users.add(new User(userCount++, "Admam", LocalDate.now().minusYears(30)));
        users.add(new User(userCount++, "Adan", LocalDate.now().minusYears(25)));
        users.add(new User(userCount++, "Abdomen", LocalDate.now().minusYears(15)));

    }
    //findAll()
    public List<User> findAll(){
        return users;
    }

    //findOne()
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
        // save()
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
}
