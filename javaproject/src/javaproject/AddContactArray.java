package javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddContactArray {
	// private HashMap<String,AddressContact> add;
	private HashMap<String, AddressContact> arr;
	private HashMap<String, HashMap<String, AddressContact>> addbook = new HashMap<String, HashMap<String, AddressContact>>();

	public void addAddressBook(String name) {
		HashMap<String, AddressContact> obj = new HashMap<String, AddressContact>();
		addbook.put(name, obj);
	}

	public void selectAddBook(String name) {
		this.arr = addbook.get(name);
	}

	public boolean containsKey(String firstName) {
		if (this.arr.containsKey(firstName))
			return true;
		else
			return false;
	}

	public void addContact(String firstName, String lastName, String city, int zip, long phoneNo, String email) {
		AddressContact add = new AddressContact(firstName, lastName, city, zip, phoneNo, email);
		arr.put(firstName, add);
	}

	public void editContact(String firstName, String lastName, String city, int zip, long phoneNo, String email) {
		AddressContact add = new AddressContact(firstName, lastName, city, zip, phoneNo, email);
		arr.replace(firstName, add);
		System.out.println("Record Changed");

	}

	public void deleteContact(String firstName) {
		arr.remove(firstName);
		System.out.println("Contact deleted");
	}

	public void searchCity(String cityname) {
		addbook.entrySet().stream()
				.forEach(y -> y.getValue().entrySet().stream().filter(m -> ((m.getValue()).city).equals(cityname))
						.map(Map.Entry::getValue).map(a -> a.firstName).forEach(System.out::println));

	}

	public void countByCity(String cityname) {
		List<Entry<String, AddressContact>> myList = new ArrayList<Entry<String, AddressContact>>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream()
				.filter(m -> ((m.getValue()).city).equals(cityname)).forEach(e -> myList.add(e)));
		System.out.println(myList.size());

	}

	public void sortName() {
		ArrayList<String> myList = new ArrayList<String>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream().forEach(e -> myList.add(e.getValue().firstName)));
		Collections.sort(myList);
		System.out.println(myList);

	}
}
