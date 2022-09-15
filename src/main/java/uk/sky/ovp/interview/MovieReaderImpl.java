package uk.sky.ovp.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class MovieReaderImpl {


	private static final String fileName = "movies.json";
	
	public MovieReaderImpl() {}
	
	public Stream<Movie> runMovieReader() throws IOException {
		 
		InputStream inputStream = null;
		Stream<Movie> movies = null;
		
		try {
			
			inputStream = getResourceFileAsInputStream(fileName);
			movies = MovieReader.getMovies(inputStream);
			
		} catch (IOException ex) {
			inputStream.close();
		} finally {
	    	inputStream.close();
	    }
	    
		movies.forEach(System.out::println);
		return movies;
	}
	
	public  InputStream getResourceFileAsInputStream(String fileName) throws IOException {
		 
		ClassLoader classLoader = getClass().getClassLoader();
		
		return new FileInputStream(
				new File(classLoader.getResource(fileName).getFile())
		);
	}
	 
}
