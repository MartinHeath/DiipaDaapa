package edu.uta.courses.service.impl;
/**
 *
 * @author Martin
 */
import edu.uta.courses.service.HelloService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import edu.uta.courses.repository.HelloRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
    
    @Autowired
    HelloRepository helloRepo;

    public String getNow() {
        String l = helloRepo.getNow();
        return l;
    }

    public Integer getLuckyNumber() {
        Random num = new Random();
        return num.nextInt(100);
    }
    
}
