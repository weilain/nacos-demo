package discovery;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author carzy
 */
@SpringBootApplication
@NacosPropertySource(dataId = "server-a.properties", groupId = "demo")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}