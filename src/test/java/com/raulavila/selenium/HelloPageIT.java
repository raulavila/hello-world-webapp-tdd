package com.raulavila.selenium;

import com.raulavila.HelloWorldWebappTddApplication;
import com.raulavila.selenium.system.EnvironmentConstants;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.raulavila.selenium.system.EnvironmentConstants.SERVER_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloWorldWebappTddApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:" + SERVER_PORT)
public class HelloPageIT extends FluentTest {
    public WebDriver webDriver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @Test
    public void openHelloPage() throws Exception {
        goTo("http://localhost:" + SERVER_PORT + "/hello");
        
        assertThat(find(".message").getText())
                .contains("Hello World");
    }
}
