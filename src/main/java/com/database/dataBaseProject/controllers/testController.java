package com.database.dataBaseProject.controllers;

import com.database.dataBaseProject.dbSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @Autowired
    private dbSetting dbSetting;

    @Value("${my.name}")
    private List<String> list;

    @GetMapping("/test")
    public String showTest(){
        return "{ connection: " + dbSetting.getConnection() +",\nhost: "+ dbSetting.getHost()+",\nport: "+dbSetting.getPort()+"}";
    }
    @Autowired
    private Environment env;

    @GetMapping("/envdetails")
    public String envDetails(){
        return env.toString();
    }
}
