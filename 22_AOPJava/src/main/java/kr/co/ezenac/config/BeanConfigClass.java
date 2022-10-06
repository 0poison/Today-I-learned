package kr.co.ezenac.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "kr.co.ezenac.beans", "kr.co.ezenac.advisor" })
@Configuration
public class BeanConfigClass {

}
