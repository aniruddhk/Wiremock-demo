package com.ak.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class WireMockConfig {

    private static final Logger logger = LoggerFactory.getLogger(WireMockConfig.class);

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {
        WireMockConfiguration config = WireMockConfiguration.wireMockConfig()
                .port(8081)
                .withRootDirectory("src/main/resources");
        WireMockServer wireMockServer = new WireMockServer(config);



        wireMockServer.getStubMappings().forEach(mapping -> logger.info("Loaded mapping: {}", mapping.getName()));


        return wireMockServer;
    }
}
