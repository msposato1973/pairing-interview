package uk.sky.ovp.interview.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.sky.ovp.interview.Movie;
import uk.sky.ovp.interview.MovieDatabase;

public class MovieDatabaseImpl implements MovieDatabase {
	
	private Stream<Movie> movies;
	
	public Stream<Movie> getMovies() {
		return movies;
	}

	private void setMovies(Stream<Movie> movies) {
		this.movies = movies;
	}

	public MovieDatabaseImpl(Stream<Movie> movies) {
		setMovies(movies);
	}

	public MovieDatabaseImpl() {
		super();
		 
	}

	@Override
	public Optional<Movie> findByTitle(String title) {
	
		Optional<Movie> movieList = getMovies()
				.filter(
						m -> m.getTitle().equalsIgnoreCase(title)
				).findFirst();
 
		return (movieList.isPresent()) ? movieList : Optional.empty() ;
	}

	@Override
	public Collection<Movie> fuzzyMatch(String titleRegexp) {

		Collection<Movie>  movieList = getMovies()
				.filter(
						m -> m.getTitle().matches(titleRegexp)
				).collect(Collectors.toList());
		
		//Matrix.*
		return (movieList.isEmpty() || movieList== null) ? List.of() :  movieList;
	}

	@Override
	public Collection<Movie> findByGenres(String... genres) {
		Collection<Movie>  movieList = getMovies()
				.filter(
						m -> {
							String[] g = genres;
							return m.getGenres().contains(g);
						}
				).collect(Collectors.toList());
				
				return movieList;
	}

	@Override
	public Collection<Movie> findByGenres(GenreQuery query) {
		
		Collection<Movie>  movieList = getMovies()
		.filter(
				m -> m.getGenres().containsAll(query.getGenres()
			   )
		).collect(Collectors.toList());
		
		return movieList;
	}

}
