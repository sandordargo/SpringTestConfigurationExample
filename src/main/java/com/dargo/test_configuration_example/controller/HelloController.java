package com.dargo.test_configuration_example.controller;

import com.dargo.test_configuration_example.resource.Data;
import com.dargo.test_configuration_example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

@RestController
public class HelloController {

  private HelloService service = new HelloService();

  @Autowired
  private PrintStream out;

  HelloController(PrintStream out) {
    this.out = out;
  }

  @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "application/json")
  public Data greet(@RequestParam(value = "name", required = false, defaultValue = "mate") String name) {

    Data data = new Data();
    service.addGreetingTo(data, name);
    out.println(data.getGreeting());
    return data;
  }

}
