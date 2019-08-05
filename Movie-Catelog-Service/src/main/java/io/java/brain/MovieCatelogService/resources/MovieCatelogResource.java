package io.java.brain.MovieCatelogService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.java.brain.MovieCatelogService.model.CatelogItem;
import io.java.brain.MovieCatelogService.model.Movie;
import io.java.brain.MovieCatelogService.model.UserRating;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
	
	@Autowired //it is working as consumer which consume the all functionality in existing class
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientbuilder;
	
	@RequestMapping("/{user_id}")
	public List<CatelogItem> getCatelog(@PathVariable("user_id") String user_id ){

		/*
		 * RestTemplate restTemplate = new RestTemplate();//for making api call
		 */
		
		/*
		 * List<Rating> ratings = Arrays.asList( new Rating("123", 4), new Rating("345",
		 * 1), new Rating("345", 1));
		 */
		
		//UserRating ratings = restTemplate.getForObject("http://localhost:5003/ratingData/users/"+user_id,UserRating.class);
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingData/users/"+user_id,UserRating.class);//calling by eureka service discovery

		return ratings.getUserRating().stream().map(rating->{
			//Movie movie =restTemplate.getForObject("http://localhost:5002/movies/"+rating.getMovieId(), Movie.class);
			Movie movie =restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			CatelogItem cat = new CatelogItem(movie.getName(), "ggg", rating.getRating());
			return cat;
		})
				.collect(Collectors.toList());
	}
	//get all rated movie id


	//for each movie if call movie information
	//put them all together
	/*
	 * return Collections.singletonList( new CatelogItem("abcd", "gdgfhgf", 5) );
	 */

}

