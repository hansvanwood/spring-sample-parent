package com.example.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MovieService {

    public void print() {
        System.out.println("MovieService print...");
    }
}