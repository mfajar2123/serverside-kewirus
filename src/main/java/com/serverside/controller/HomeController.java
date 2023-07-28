package com.serverside.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHomePage() {
        return "index"; // Nama file HTML tanpa ekstensi yang akan digunakan sebagai halaman utama
    }
}
