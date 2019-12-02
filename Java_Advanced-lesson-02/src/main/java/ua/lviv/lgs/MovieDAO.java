package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

	private static String READ_ALL = "select * from movie";
	private static String CREATE = "insert into movie(`movie_name`, `movie_description`, `price`, `imdb`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from movie where id =?";
	private static String UPDATE_BY_ID = "update movie set movie_name=?, movie_description = ?, price = ?, imdb = ? where id = ?";
	private static String DELETE_BY_ID = "delete from movie where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MovieDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Movie movie) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, movie.getMovieName());
		preparedStatement.setString(2, movie.getMovieDescription());
		preparedStatement.setDouble(3, movie.getPrice());
		preparedStatement.setString(4, movie.getImdb());
		preparedStatement.executeUpdate();
	}

	public Movie read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MovieMapper.map(result);
	}

	public void update(Movie movie) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, movie.getMovieName());
		preparedStatement.setString(2, movie.getMovieDescription());
		preparedStatement.setDouble(3, movie.getPrice());
		preparedStatement.setString(4, movie.getImdb());
		preparedStatement.setInt(5, movie.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Movie> readAll() throws SQLException {
		List<Movie> listOfMovies = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMovies.add(MovieMapper.map(result));
		}
		return listOfMovies;
	}

}