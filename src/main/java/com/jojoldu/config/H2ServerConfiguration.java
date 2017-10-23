package com.jojoldu.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

/**
 * Created by jojoldu@gmail.com on 2017. 10. 24.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Configuration
@Profile("local")
@Slf4j
public class H2ServerConfiguration {
    @Bean
    public Server h2TcpServer() throws SQLException {
        final Server server = Server.createTcpServer().start();
        if(server.isRunning(true)) {
            log.info("H2 Tcp Server was started and is running.");
        }
        return server;
    }
}
