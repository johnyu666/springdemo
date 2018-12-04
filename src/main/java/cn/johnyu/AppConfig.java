package cn.johnyu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
@ImportResource("classpath:repository.xml")
@Import(RepositoryConfig.class)
@ComponentScan(basePackages = {"cn.johnyu.dao"})
public class AppConfig {
    public static void main(String[] args) throws Exception{
       // ApplicationContext context1= new AnnotationConfigApplicationContext(AppConfig.class);
       ApplicationContext context2=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
