package tn.esprit.twin3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy // pr activer service AOP
@EnableScheduling
public class Twin3Application {

    public static void main(String[] args) {
        SpringApplication.run(Twin3Application.class, args);
    }

}
