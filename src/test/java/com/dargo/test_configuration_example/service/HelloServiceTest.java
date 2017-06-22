package com.dargo.test_configuration_example.service;

import com.dargo.test_configuration_example.resource.Data;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

  @Test
  public void serviceShouldReturnDataWithGreeting() {
    HelloService service = new HelloService();
    String name = "Peter File";
    Data data = new Data();
    service.addGreetingTo(data, name);
    assertEquals("Hello, Peter File!", data.getGreeting());
  }


}
