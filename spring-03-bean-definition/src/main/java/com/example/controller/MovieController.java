package com.example.controller;

import com.example.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    public void print() {
        movieService.print();
    }

}
