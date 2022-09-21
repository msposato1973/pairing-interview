package uk.sky.ovp.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import uk.sky.ovp.interview.impl.MovieDatabaseImpl;

class MovieDatabaseTest {
 
	private  MovieDatabase movieDatabase = null;
	   
    private String  filename = "movies.json"; 
    
    @Test
    void findByNameWorksInAbsentScenario() throws IOException {
     
    	Stream<Movie>  movies = MovieReader.getMovies(getResoulseAsStram());
    	movieDatabase = new  MovieDatabaseImpl(movies); 
    	 
        Optional<Movie> movie = movieDatabase.findByTitle("Matrix 4");
       
        assertFalse(movie.isPresent());
    }
    
    //
    
    @Test
    void findByNameWorksInAbsentScenarioWithNotExistTitle() throws IOException {

    	Stream<Movie>  movies = MovieReader.getMovies(getResoulseAsStram());
    	movieDatabase = new  MovieDatabaseImpl(movies); 
    	
     
    	String title = "Avengers: Age of Ultron";
    	
    	Optional<Movie> movie = movieDatabase.findByTitle(title);

        assertFalse(movie.isPresent());
    }
    
    @Test
    void findByNameWorksInAbsentScenarioWithCorrectTitle() throws IOException {

    	Stream<Movie>  movies = MovieReader.getMovies(getResoulseAsStram());
    	movieDatabase = new  MovieDatabaseImpl(movies); 
    	
    	
    	String title = "The Container of pudding";
    	
    	Optional<Movie> movie = movieDatabase.findByTitle(title);

        assertTrue(movie.isPresent());
    }
    
    
    @Test
    void findByNameWorksInAbsentScenarioWithReExression() throws IOException {
    	

    	Stream<Movie>  movies = MovieReader.getMovies(getResoulseAsStram());
    	movieDatabase = new  MovieDatabaseImpl(movies); 
    	
     
    	String titleRegExpo = "Matrix.*";
    	
    	Collection<Movie> moviesList = movieDatabase.fuzzyMatch(titleRegExpo);

        assertFalse(moviesList.isEmpty());
    }
    
    

	private InputStream getResoulseAsStram() throws FileNotFoundException {
		 ClassLoader classLoader = getClass().getClassLoader();
		return new FileInputStream(new File(classLoader.getResource(filename).getFile()));
	}
}
