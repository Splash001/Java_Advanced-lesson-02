package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private int id;
	private String movieName;
	private String movieDescription;
	private double price;
	private String imdb;

	public Movie(int id, String movieName, String movieDescription, double price, String imdb) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.price = price;
		this.imdb = imdb;
	}

	public Movie(String movieName, String movieDescription, double price, String imdb) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.price = price;
		this.imdb = imdb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return id + " --> Movie name - " + "\"" + movieName + "\"" + ", movie descrription - " + "\"" + movieDescription
				+ "\"" + ", price - " + price + ", rated - " + imdb;
	}

	public static List<Movie> createDefaultData() {
		List<Movie> movieList = new ArrayList<>();
		movieList.add(new Movie("Tittanic", "James Cameron cult movie", 99.99, "9.7"));
		movieList.add(new Movie("Shawshank Redemption", "Highest rated movie in the world", 60.00, "9.9"));
		movieList.add(new Movie("Avengers", "Highest grossing movie of all times", 65.00, "8.7"));
		movieList.add(new Movie("Taras Bulba", "Historic drama", 40.50, "6.5"));
		movieList.add(new Movie("True lies", "Comedy with Arnold Shwartzenegger", 25.15, "4.5"));
		return movieList;
	}

}