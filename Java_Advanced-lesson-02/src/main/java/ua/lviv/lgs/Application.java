package ua.lviv.lgs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import ua.lviv.lgs.Director;

public class Application {

	public static int menu() {
		System.out.println();
		System.out.println("----STANDARD DATA----");
		System.out.println("Enter 11 to load standard data");
		System.out.println("----MOVIES DATABASE----");
		System.out.println("Enter 21 to add movie to database");
		System.out.println("Enter 22 to delete movie from database based on id");
		System.out.println("Enter 23 to add additional info to movie based on id");
		System.out.println("Enter 24 to show all movies");
		System.out.println("----DIRECTORS DATABASE----");
		System.out.println("Enter 31 to add Director to the database");
		System.out.println("Enter 32 to delete Director from database based on id");
		System.out.println("Enter 33  to add additional info to Director based on id");
		System.out.println("Enter 34 to show all Directors");
		System.out.println("----MOVIE CATEGORY DATABASE");
		System.out.println("Enter 41 to add category to the database");
		System.out.println("Enter 42 to delete category from the database based on id");
		System.out.println("Enter 43 to add additional info into the category based on the id");
		System.out.println("Enter 44 to show all categories");
		System.out.println("----EXITING THE PROGRAMM----");
		System.out.println("Enter 0 to exit");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Make Your choice: ");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {

		DirectorDAO directorDAO = new DirectorDAO(ConnectionUtils.openConnection());
		MovieDAO movieDAO = new MovieDAO(ConnectionUtils.openConnection());
		MovieCategoryDAO movieCategoryDAO = new MovieCategoryDAO(ConnectionUtils.openConnection());

		while (true) {
			switch (menu()) {

			case 11: {
				List<Director> directorsList = Director.createDefaultData();

				directorsList.stream().forEach(director -> {
					try {
						directorDAO.insert(director);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				directorDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				List<Movie> movieList = Movie.createDefaultData();

				movieList.stream().forEach(movie -> {
					try {
						movieDAO.insert(movie);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				movieDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				List<MovieCategory> movieCategoryList = MovieCategory.createDefaultData();

				movieCategoryList.stream().forEach(movieCategory -> {
					try {
						movieCategoryDAO.insert(movieCategory);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				movieCategoryDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				break;
			}

			case 21: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter movie name : ");
				String movieName = reader.readLine();
				System.out.println("Enter movie desription : ");
				String movieDescription = reader.readLine();
				;
				System.out.println("Enter movie's price (example: 22.22) : ");
				Double price = Double.parseDouble(reader.readLine());
				System.out.println("Enter movies imdb : ");
				String imdb = reader.readLine();
				Movie movie = new Movie(movieName, movieDescription, price, imdb);
				movieDAO.insert(movie);
				break;
			}

			case 22: {
				movieDAO.readAll().forEach(System.out::println);
				System.out.println("Choose id to delete: ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				movieDAO.delete(id);
				break;
			}

			case 23: {
				System.out.println("Enter id to search : ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Movie movieFromDB = movieDAO.read(id);
				System.out.println(movieFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the data to change the name of the movie : ");
				String movieName = reader.readLine();
				System.out.println("Enter the data to change movie's description : ");
				String movieDescription = reader.readLine();
				System.out.println("Enter data to change the movie's price(using 22.22 format):");
				double price = Double.parseDouble(reader.readLine());
				System.out.println("Enter data to change movie's imdb :");
				String imdb = reader.readLine();

				if (movieName.equals("")) {
					movieFromDB.setMovieName(movieFromDB.getMovieName());
				} else {
					movieFromDB.setMovieName(movieName);
				}

				if (movieDescription.equals("")) {
					movieFromDB.setMovieDescription(movieFromDB.getMovieDescription());
				} else {
					movieFromDB.setMovieDescription(movieDescription);
				}

				if (price == 0.0) {
					movieFromDB.setPrice(movieFromDB.getPrice());
				} else {
					movieFromDB.setPrice(price);
				}

				if (imdb.equals("")) {
					movieFromDB.setImdb(movieFromDB.getImdb());
				} else {
					movieFromDB.setImdb(imdb);
				}

				movieDAO.update(movieFromDB);
				break;
			}

			case 24: {
				movieDAO.readAll().forEach(System.out::println);
				break;
			}

			case 31: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Directors name : ");
				String firstName = reader.readLine();
				System.out.println("Enter Director's Last name : ");
				String lastName = reader.readLine();
				System.out.println("Enter Directors e-mail:");
				String email = reader.readLine();
				System.out.println("Enter Director's address :");
				String address = reader.readLine();
				System.out.println("Enter Director's date of birth : ");
				int birthdayDate = Integer.parseInt(reader.readLine());
				Director director = new Director(firstName, lastName, email, address, birthdayDate);
				directorDAO.insert(director);
				break;
			}

			case 32: {
				directorDAO.readAll().forEach(System.out::println);
				System.out.println("Enter id to delete : ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				directorDAO.delete(id);

				break;
			}

			case 33: {
				System.out.println("Enter searched id :");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Director directorFromDB = directorDAO.read(id);
				System.out.println(directorFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter data if you want to change Director's name : ");
				String firstName = reader.readLine();
				System.out.println("Enter data if you want to change Director's last name : ");
				String lastName = reader.readLine();
				System.out.println("ВEnter data if you want to change Director's e-mail : ");
				String email = reader.readLine();
				System.out.println("Enter data if you want to change Director's address : ");
				String address = reader.readLine();
				System.out.println("Enter data if you want to change Director's date of birth : ");
				int year = Integer.parseInt(reader.readLine());
				if (firstName.equals("")) {
					directorFromDB.setFirstName(directorFromDB.getFirstName());
				} else {
					directorFromDB.setFirstName(firstName);
				}

				if (lastName.equals("")) {
					directorFromDB.setLastName(directorFromDB.getLastName());
				} else {
					directorFromDB.setLastName(lastName);
				}

				if (email.equals("")) {
					directorFromDB.setEmail(directorFromDB.getEmail());
				} else {
					directorFromDB.setEmail(email);
				}

				if (address.equals("")) {
					directorFromDB.setAddress(directorFromDB.getAddress());
				} else {
					directorFromDB.setAddress(address);
				}

				if (year == 0) {
					directorFromDB.setBirthdayDate(directorFromDB.getBirthdayDate());
				} else {
					directorFromDB.setBirthdayDate(year);
				}

				directorDAO.update(directorFromDB);
				break;
			}

			case 34: {
				directorDAO.readAll().forEach(System.out::println);
				break;
			}

			case 41: {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter movies category : ");
				String categoryName = sc.nextLine();
				MovieCategory movieCategory = new MovieCategory(categoryName);
				movieCategoryDAO.insert(movieCategory);
				break;
			}

			case 42: {
				movieCategoryDAO.readAll().forEach(System.out::println);
				System.out.println("Enter id to be deleted : ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				movieCategoryDAO.delete(id);
				break;
			}

			case 43: {
				System.out.println("Enter searched id : ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				MovieCategory movieCategoryFromDB = movieCategoryDAO.read(id);
				System.out.println(movieCategoryFromDB.toString());
				System.out.println("Enter data, if You want to change movie's category");
				String categoryName = sc.nextLine();

				if (categoryName.equals("")) {
					movieCategoryFromDB.setCategoryName(movieCategoryFromDB.getCategoryName());
				} else {
					movieCategoryFromDB.setCategoryName(categoryName);
				}

				movieCategoryDAO.update(movieCategoryFromDB);
				break;
			}

			case 44: {
				movieCategoryDAO.readAll().forEach(System.out::println);
				break;
			}

			case 0: {
				System.out.println("Thank You for using our online cinema\n");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("There is no such option in menu!");
				break;
			}
			}
		}
	}

}