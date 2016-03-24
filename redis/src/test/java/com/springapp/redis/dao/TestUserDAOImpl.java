package com.springapp.redis.dao;

import com.springapp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by guoqing on 2016/3/24 0024.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/redis-applicationContext.xml")
public class TestUserDAOImpl {

    @Autowired
    private  UserDAO userDAO;

    @Test
    public void main() {
//        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring/redis-applicationContext.xml");
//        UserDAO userDAO = (UserDAO)ac.getBean("userDAO");
        User user1 = new User();
        user1.setId(1);
        user1.setName("obama");
        userDAO.saveUser(user1);
        User user2 = userDAO.getUser(1);
        System.out.println(user2.getName());
    }
}
