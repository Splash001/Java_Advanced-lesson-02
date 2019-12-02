package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper {

	public static Movie map(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String movieName = result.getString("movie_name");
		String movieDescription = result.getString("movie_description");
		double price = result.getDouble("price");
		String imdb = result.getString("imdb");

		return new Movie(id, movieName, movieDescription, price, imdb);
	}
}