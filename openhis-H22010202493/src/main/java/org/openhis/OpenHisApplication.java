package org.openhis;

import org.openhis.domain.test.axon.entity.ClassRoomDetils;
import org.openhis.domain.test.axon.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动程序
 *
 * @author system
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, AxonServerAutoConfiguration.class},
        scanBasePackages = {"org.openhis","com.yomahub.liteflow.core"})
@MapperScan("org.openhis.domain.repository")
@EnableAsync
public class OpenHisApplication {
    public static void main(String[] args) throws UnknownHostException {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        ConfigurableApplicationContext application = SpringApplication.run(OpenHisApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n----------------------------------------------------------\n\t"
                + "Application OpenHis is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + path + "/\n"
                + "----------------------------------------------------------");
        EventBus eventBus = application.getBean(EventBus.class);
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent("ORDER_001", new ClassRoomDetils("101", "一年一班"));
        eventBus.publish(GenericEventMessage.asEventMessage(
                orderCreatedEvent.toString()
        ));

    }

}
