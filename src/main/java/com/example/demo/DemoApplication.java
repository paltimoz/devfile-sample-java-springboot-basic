package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello2")
    String home() {
        return "Hello World!";
    }

    @PostMapping("/test")
    ResponseEntity<String> test(@RequestBody TestRequest request){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(request.getUrl(), String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

class TestRequest{
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
