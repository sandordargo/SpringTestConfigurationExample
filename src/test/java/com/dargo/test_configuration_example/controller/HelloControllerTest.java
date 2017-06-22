package com.dargo.test_configuration_example.controller;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

  @Test
  public void controllerPrintedGreetingToOutput() throws UnsupportedEncodingException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(outputStream);
    HelloController controller = new HelloController(out);

    controller.greet("Peter File");
    String expected = "Hello, Peter File!" + System.getProperty("line.separator");
    String actual = new String(outputStream.toByteArray(), "UTF-8");

    assertEquals(expected, actual);
  }
}
