package com.example.twelveFactor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie retrieveMovie(@PathVariable Long id){
        return movieRepository.findById(id).get();
    }

    @PostMapping("/movies")
    public Long createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie).getId();
    }

}
