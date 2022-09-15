package uk.sky.ovp.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import uk.sky.ovp.interview.impl.MovieDatabaseImpl;

class MovieDatabaseTest {
    private final MovieDatabase movieDatabase = new MovieDatabaseImpl();
    
     

    @Test
    void findByNameWorksInAbsentScenario() {
        Optional<Movie> movie = movieDatabase.findByTitle("Matrix 4");

        assertFalse(movie.isPresent());
    }
}
