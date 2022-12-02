package com.example.springboot_mysql_datajpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:my-application.properties")
@ConfigurationProperties(prefix = "my.service")
@ConstructorBinding
@Data
@NoArgsConstructor
public class MyProperties {

    private boolean enabled;

    private InetAddress remoteAddress;

    private Security security;

    public MyProperties(boolean enabled, InetAddress remoteAddress, Security security) {
        this.enabled = enabled;
        this.remoteAddress = remoteAddress;
        this.security = security;
    }


    @Data
    @NoArgsConstructor
    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>();

        public Security(String username, String password, @DefaultValue("USER") List<String> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }

    }
}
