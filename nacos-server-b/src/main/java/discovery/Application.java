package discovery;

import com.alibaba.boot.nacos.discovery.autoconfigure.NacosDiscoveryAutoConfiguration;
import com.alibaba.boot.nacos.discovery.properties.NacosDiscoveryProperties;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author carzy
 */
@SpringBootApplication
@EnableNacosDiscovery
@EnableConfigurationProperties(NacosDiscoveryProperties.class)
@Import(NacosDiscoveryAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}