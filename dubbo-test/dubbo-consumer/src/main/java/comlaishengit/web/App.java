package comlaishengit.web;

import com.kaishengit.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/11
 */
public class App {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dubbo-consumer.xml");
        UserService userService = (UserService) context.getBean("UserService");

        String name = userService.findById(1001);
        System.out.println("name:-->" + name);
        System.in.read();
    }

}
