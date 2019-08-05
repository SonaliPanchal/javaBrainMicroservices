package io.java.brain.MovieInfoService.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.brain.MovieInfoService.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId")String movieId)
	{
		return new Movie(movieId, "abcd");
		
	}
}
