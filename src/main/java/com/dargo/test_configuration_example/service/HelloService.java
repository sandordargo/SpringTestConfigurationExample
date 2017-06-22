package com.dargo.test_configuration_example.service;

import com.dargo.test_configuration_example.resource.Data;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
  public void addGreetingTo(Data data, String name) {
    data.setGreeting("Hello, " + name + "!");
  }
}
