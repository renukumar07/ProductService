package com.renu.productservice;

import org.springframework.web.bind.annotation.*;

//This controller supports REST API's(HTTP Requests).
//The request coming to endpoint /hello, transfer them to this controller
@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/{name}/{number}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("number") int number){
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=number;i++){
            sb.append("Hello "+name+" ");
        }
        return sb.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
