package com.agilesolutions.reference.config;

import com.agilesolutions.reference.service.CustomerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@Configuration
public class RestConfig {

    @MockitoBean
    CustomerService customerService;


}
