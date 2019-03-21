package io.spring.cloud.samples.fortuneteller.hystrixdashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableHystrixDashboard
@Controller
public class Application {

    @Value("${UIURL:http://localhost:8081}")
    String uiUrl;

    @RequestMapping(path="/")
    @ResponseBody
    public String home() {
        String uiDashboardUrl = String.format("<html><body><a href='hystrix/monitor?stream=%s/hystrix.stream'> go to my dashboard </a> </body> </html>", uiUrl);
        System.out.println(uiDashboardUrl);
        return uiDashboardUrl;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
