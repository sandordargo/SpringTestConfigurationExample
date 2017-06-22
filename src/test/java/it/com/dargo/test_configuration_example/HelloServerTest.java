package it.com.dargo.test_configuration_example;

import com.dargo.test_configuration_example.BootstrapRun;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class HelloServerTest {

  private static ConfigurableApplicationContext context;
  private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  private CloseableHttpClient httpClient = HttpClients.createDefault();

  @BeforeClass
  public static void startServer() {
    context = SpringApplication.run(TestBootstrap.class);
  }

  @AfterClass
  public static void stopServer() {
    context.stop();
  }

  @Test
  public void startServerOnPort8080() throws IOException {
    HttpGet httpGet = new HttpGet("http://localhost:8080/example-app/hello");
    HttpResponse response = httpClient.execute(httpGet);

    assertEquals(200, response.getStatusLine().getStatusCode());
  }

  @Test
  public void serverShouldLogGreeting() throws IOException {
    HttpGet httpGet = new HttpGet("http://localhost:8080/example-app/hello");
    HttpResponse response = httpClient.execute(httpGet);

    assertEquals(200, response.getStatusLine().getStatusCode());
    assertLogExists("Hello, mate!" + System.getProperty("line.separator"));
  }

  private void assertLogExists(String logToLookup) throws UnsupportedEncodingException {
      assertEquals(logToLookup, new String(outputStream.toByteArray(), "UTF-8"));
  }

  @Configuration
  @Import(BootstrapRun.class)
  public static class TestBootstrap {

    @Bean
    @Primary
    public PrintStream getPrintstream() {
      return new PrintStream(outputStream);
    }
  }
}
