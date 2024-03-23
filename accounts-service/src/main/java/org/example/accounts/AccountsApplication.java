package org.example.accounts;

import io.minio.MinioClient;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@SpringBootApplication
public class AccountsApplication {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        SpringApplication.run(AccountsApplication.class, args);
//        Build URL
//        String apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ey" +
//                "AgCiAgICAicm9sZSI6ICJhbm9uIiwKICAgICJpc3MiOiAic" +
//                "3VwYWJhc2UtZGVtbyIsCiAgICAiaWF0IjogMTY0MTc2OTIw" +
//                "MCwKICAgICJleHAiOiAxNzk5NTM1NjAwCn0.dc_X5iR_VP_" +
//                "qT0zsiyj_I_OZ2T9FtRU2BBNWN8Bu4GE";
//        URIBuilder builder = new URIBuilder();
//        builder.setScheme("ws");
//        builder.setHost("localhost");
//        builder.setPath("/realtime/v1/websocket");
//        builder.setPort(8000);
//        builder.addParameter("apiKey", apiKey);
//        String link = builder.build().toURL().toString();
//
////        Create socket
//        MinioClient minioClient = MinioClient.builder().build();
    }
}
