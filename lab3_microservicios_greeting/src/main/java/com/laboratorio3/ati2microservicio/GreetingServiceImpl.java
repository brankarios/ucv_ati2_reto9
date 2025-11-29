package com.laboratorio3.ati2microservicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private Environment env;

    @Override
    public String getServiceGreeting() throws Exception {
        String portValue = env.getProperty("server.port");
        return "Hello from port: " + portValue;
    }
}