package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
@Controller
@EnableCaching
@MapperScan("com.example.mapper")
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return "Hello World!";
    }

    @GetMapping("/loginGet")
    @ResponseBody
    public String loginGet() {
        return "Login Page";
    }

    @PostMapping("/loginPost")
    @ResponseBody
    public String loginPost() {
        return "Login Post Request";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("avatar") MultipartFile file,String title) throws IOException {

        byte[] bytes = file.getBytes();
        FileOutputStream outputStream = new FileOutputStream(new File("D:/ccc.txt"));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        return "页面传回来的值为："+title;
    }

}
