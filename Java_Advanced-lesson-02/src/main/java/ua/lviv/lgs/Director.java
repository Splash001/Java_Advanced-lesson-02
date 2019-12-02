package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Director {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int birthdayDate;

	public Director(int id, String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public Director(String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(int birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@Override
	public String toString() {
		return id + " --> Name - " + "\"" + firstName + "\"" + ", Last Name - " + "\"" + lastName + "\"" + ", email - "
				+ email + ", address - " + "\"" + address + "\"" + ", date of birth - " + birthdayDate;
	}

	public static List<Director> createDefaultData() {
		List<Director> directorsList = new ArrayList<>();
		directorsList.add(new Director("Stephen", "Spielberg", "spielberg.steve@mail.com", "New York, USA", 1946));
		directorsList.add(new Director("George", "Lucas", "lucas.george@mail.com", "Washington, USA", 1944));
		directorsList.add(new Director("Martin", "Scorsese", "scorsese@mail.com", "Quieens, USA", 1942));
		directorsList.add(new Director("Francis", "Coppola", "ford@mail.com", "Detroit, USA", 1939));
		directorsList.add(new Director("Woody", "Allen", "wallen@mail.com", "Brooklyn, USA", 1935));
		return directorsList;
	}
}