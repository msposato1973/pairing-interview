package uk.sky.ovp.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.sky.ovp.interview.Movie;
import uk.sky.ovp.interview.MovieDatabase;
import uk.sky.ovp.interview.impl.MovieDatabaseImpl;


public class MovieService {

	private final MovieDatabase movieDatabase;
	
	public MovieService(MovieDatabaseImpl movieDatabase) {
	 	this.movieDatabase = movieDatabase;
	}
	
	public Optional<Movie> findByTitle(String title){
		 Optional<Movie> movie = this.movieDatabase.findByTitle(title);
		 return (movie.isPresent()) ? movie : Optional.ofNullable(null);
	}
	
	private List<Movie> filterByTitle(String title, Stream<Movie> movies) {
		List<Movie> listMovie = 
				movies
					.filter(m -> m.getGenres()
							.stream()
    							.anyMatch(
    									a -> a.equalsIgnoreCase("")
    							)
				    )
				    .collect(Collectors.toList()
		);
		
		return listMovie;
	}
	
}
