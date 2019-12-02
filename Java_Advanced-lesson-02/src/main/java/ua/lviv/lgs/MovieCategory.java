
package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class MovieCategory {

	private int id;
	private String categoryName;

	public MovieCategory(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public MovieCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return id + " --> Category name - " + "\"" + categoryName + "\"";
	}

	public static List<MovieCategory> createDefaultData() {
		List<MovieCategory> categoryMovieList = new ArrayList<>();
		categoryMovieList.add(new MovieCategory("Action"));
		categoryMovieList.add(new MovieCategory("Drama"));
		categoryMovieList.add(new MovieCategory("Documental"));
		categoryMovieList.add(new MovieCategory("Biographic"));
		categoryMovieList.add(new MovieCategory("Comedy"));
		return categoryMovieList;
	}
}
