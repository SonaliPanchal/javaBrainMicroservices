package io.java.brain.RatingDataService.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.brain.RatingDataService.model.Rating;
import io.java.brain.RatingDataService.model.UserRating;

@RestController
@RequestMapping("/ratingData")
public class RatingResource {
	@RequestMapping("/{movieId}")
	public Rating getrating(@PathVariable("movieId")String movieId)
	{
		return new Rating(movieId, 6);
		
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getrating1(@PathVariable("userId")String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("A", 4),
				new Rating("fdff", 1),
				new Rating("opqrs", 1));
		
		
		UserRating userRatings = new UserRating();
		userRatings.setUserRating(ratings);
		return userRatings;
		
	}

}
