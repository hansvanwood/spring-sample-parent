package com.example.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("singleton")
public class MovieController {

    public void print() {
        System.out.println("MovieController print...");
    }

}
