package uk.sky.ovp.interview.impl;

import java.util.Collection;
import java.util.Optional;

import uk.sky.ovp.interview.Movie;
import uk.sky.ovp.interview.MovieDatabase;

public class MovieDatabaseImpl implements MovieDatabase {

	public MovieDatabaseImpl() {
		super();
		 
	}

	@Override
	public Optional<Movie> findByTitle(String title) {
		 
		return Optional.empty();
	}

	@Override
	public Collection<Movie> fuzzyMatch(String titleRegexp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findByGenres(String... genres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findByGenres(GenreQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
