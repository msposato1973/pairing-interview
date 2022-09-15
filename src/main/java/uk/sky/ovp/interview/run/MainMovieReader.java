package uk.sky.ovp.interview.run;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.sky.ovp.interview.Movie;
import uk.sky.ovp.interview.MovieReaderImpl;

public class MainMovieReader {

	public static void main(String[] args) {
		MovieReaderImpl impl = new MovieReaderImpl();
		 
		try {
			Stream<Movie> movies = impl.runMovieReader();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
