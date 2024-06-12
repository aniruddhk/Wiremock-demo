package com.ak.wiremock;
/*
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

import static java.lang.Thread.currentThread;

@Configuration
public class WireMockConfig1 {

    private static final Logger logger = LoggerFactory.getLogger(WireMockConfig1.class);
    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {

        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration();
        wireMockConfiguration.port(8081).disableRequestJournal();
        wireMockConfiguration.extensions(new ResponseTemplateTransformer(false));
        URL stubUrl = currentThread().getContextClassLoader().getResource("mappings");
        String stubPath = stubUrl.toString().contains("BOOT-INF/classes") ? "BOOT-INF/classes/mappings" : "mappings";
        wireMockConfiguration.fileSource(new ClasspathFileSource(stubPath));
        WireMockServer wireMockServer = new WireMockServer(wireMockConfiguration);
        logger.info("Revati : "+stubPath);
        wireMockServer.getStubMappings().forEach(mapping -> logger.info("Loaded mapping Revati: {}", mapping.getName()));

        return wireMockServer;
/*
        // Manually load mappings
        try {
            String soapResponse = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("mappings/soap-response.json").toURI())));
            wireMockServer.addStubMapping(StubMapping.buildFrom(soapResponse));

            String jsonResponse = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("mappings/json-response.json").toURI())));
            wireMockServer.addStubMapping(StubMapping.buildFrom(jsonResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}*/

